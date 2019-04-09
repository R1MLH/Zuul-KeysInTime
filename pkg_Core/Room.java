package pkg_Core;
import pkg_GameElements.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Random;

/**
 * La classe pour les piece qui constituent le monde
 * 
 * @author Erwan Mailharro
 * @version 22/03/2016
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private HashMap<String, Door> aDoors;
    private ItemList aItems;
    private HashMap<String,NonPlayerCharacters> aChars;
    private Grid aGrid;
    private HashMap<Coordinates,Entity> aEntities;

    /** 
     * Constructeur  de la classe Room
     */
    public Room(final String pDescription)
    {
        this(pDescription,"room.png");
    }// Room(pDescription)

    /** 
     * Constructeur Naturel de la classe Room
     */
    public Room(final String pDescription, String pImage)
    {
        this.aDescription = pDescription;
        aExits = new HashMap<String, Room>();
        aImageName = "/Images/Room/" + pImage;
        aItems = new ItemList();
        aDoors = new HashMap<String, Door>();
        aChars = new HashMap<String,NonPlayerCharacters>();
        aGrid = new Grid(39,24);
        aEntities = new HashMap<Coordinates,Entity>();
    }// Room(pDescription)

    public void setDoorLocation(String pDir,final int pX,final int pY)
    {
        //         this.getDoor(pDir).setLocation(this,pX,pY);
    }
    // 
    //     /**
    //      * Initialise les sorties nord, sud, est et ouest - obsolete
    //      */ 
    //     public void setExits (final Room pNorth, final Room pEast, final Room pSouth, final Room pWest)
    //     {
    //         if(pNorth != null)
    //             this.aExits.put("north",pNorth);
    //         if(pEast != null)
    //             this.aExits.put("east",pEast);
    //         if(pSouth != null)
    //             this.aExits.put("south",pSouth);
    //         if(pWest != null)
    //             this.aExits.put("west",pWest);
    // 
    //     }//SetExits 

    /**
     * Associe une sortie a une direction pour la current room
     */
    public void setExit(String pDirection, Room pTarget)
    {
        this.aExits.put(pDirection, pTarget);
        //this.setDoor(pDirection,new Door(this,pDirection));
    }

    /**
     * Associe une sortie a une direction pour la current room
     */
    public void setExit(String pDirection, Room pTarget,Item pKey)
    {
        this.aExits.put(pDirection, pTarget);
        //this.setDoor(pDirection,new Door(this,pDirection,pKey));
    }

    /**
     * Associe une sortie a une direction et une porte
     */
    public void setExit(String pDirection, Room pTarget, Door pDoor)
    {
        this.aExits.put(pDirection, pTarget);
        this.setDoor(pDirection, pDoor);
    }

    /**
     * associe une direction a une porte
     */
    public void setDoor(String pDirection, Door pDoor)
    {
        this.aDoors.put(pDirection, pDoor);
    }

    /**
     * renvoie la description de la piece
     */
    public String getDescription() {return this.aDescription;}//getDescription

    /**
     * renvoie la sortie dans la direction en parametre
     */
    public Room getExit(String pDirection){return this.aExits.get(pDirection);}

    public Door getDoor(String pDirection) {return this.aDoors.get(pDirection);}

    /**
     * renvoie les sorties sous forme de chaine
     */
    public String getExitString()
    {
        String vReturnString = new String();
        vReturnString = "SORTIES : ";
        Set<String> keys = aExits.keySet();
        for(String exit : keys) {
            if (this.getDoor(exit) !=null )vReturnString += " " + exit;
        }
        return vReturnString;
    }

    /**
     * renvoie une description de la piece avec les sorties et les objets
     */
    public String getLongDescription()
    {        return "--------------------------------------------------- \n"+ this.aDescription + ".\n" + getItemString() + ".\n" + getCharacterString() + ".\n";
    }

    /**
     * renvoie l'image
     */
    public String getImageName()
    {        return aImageName;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////ITEMS

    /**
     * renvoie l'item list de la piece
     */
    public ItemList getItemList()
    {return this.aItems;
    }

    /**
     * renvoie les items de la piece sous forme de string
     */
    public String getItemString()
    {
        return "Objets dans la salle :" + this.aItems.getItemString();
    }

    /**
     * ajoute un item a la piece
     */
    public void addItem(Item pItem)
    {       // this.aItems.put(pItem.getName(),pItem);
        this.aItems.addItem(pItem);

    }

    /**
     * renvoie l'item correspondant a la string
     */
    public Item getItem(String pName)
    {
        return this.aItems.getItem(pName);
    }

    /**
     * teste si l'item est dans la piece
     */
    public boolean isItemInRoom(String pString)
    {  
        return this.aItems.containsItem(pString);
    }

    /**
     * renvoie la hashmap des sorties
     */
    public HashMap<String, Room> getExitMap()
    {return this.aExits;    }

    /**
     * teste si il existe une sortie vers la piece en parametre
     */
    public boolean hasExitTo(Room pRoom)
    {
        boolean vReturn = false;
        Set<String> keys = aExits.keySet();
        for(String exit : keys) {
            if (this.getExit(exit) == pRoom) vReturn = true;
        }
        return vReturn;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * ajoute un personnage a la room
     */
    public void addCharacter(NonPlayerCharacters pChar)
    {
        aChars.put(pChar.getName(),pChar);
       
    }

    /**
     * enleve un personage de la room
     */
    public void removeCharacter(Characters pChar)
    {
        aChars.remove(pChar.getName());
    }

    /**
     * vérifie si un personnage est dans la room
     */
    public boolean isCharInRoom(String pString)
    {
        return this.aChars.containsKey(pString);
    }

    /**
     * renvoie les sorties sous forme de chaine
     */
    public String getCharacterString()
    {
        String vReturnString = new String();
        vReturnString = "PERSONNAGES : ";

        for(NonPlayerCharacters o : aChars.values()) {
            if(o instanceof NonPlayerCharacters) vReturnString += " " + o;
        }
        return vReturnString;
    }
    
    public HashMap<String,NonPlayerCharacters> getNPCS()
    {
        return this.aChars;
    }
    

    /**
     * renvoie un personnage de la room
     */
    public Characters getChar(String pString)
    {
        return this.aChars.get(pString);
    }

    //     public Item takeItem(String pString)
    //     {
    //         Item vItem = this.aItems.get(pString);
    //         this.aItems.remove(pString);
    //         return vItem;
    //     }.

    /**
     * renvoie la grille
     */
    public Grid getGrid()
    {
        return aGrid;
    }

    /**
     * ajoute une entité dans la room et l'ajoute a la map ou la liste correspondante
     */
    public void add(Entity pE)
    {
        this.remove(pE);
        aGrid.add(pE);
        aEntities.put(pE.getCoordinates(),pE);

        if(pE instanceof Item)
        {
            this.addItem((Item) pE);
        }
        else if(pE instanceof NonPlayerCharacters)
        {
            this.addCharacter((NonPlayerCharacters) pE);
        }
    }

    /**
     * enlève une entité de la room
     */
    public void remove(Entity pE)
    {
        aGrid.remove(pE);

        for (Iterator<Coordinates> e = aEntities.keySet().iterator(); e.hasNext() ;)
        { if(e.next().equals(pE.getCoordinates()))  e.remove();

        }
    }

    /**
     * renvoie l'image de la room
     */
    public String getImage()
    {
        return this.aImageName;
    }

  
    public boolean isLocationOccupied(Coordinates pCoordinates)
    {
        return aGrid.isLocationOccupied(pCoordinates);
    }

    public HashMap<Coordinates,Entity> getEntities()
    {
        return this.aEntities;
    }

    public Entity getEntity(Coordinates pC)
    {

        for(Coordinates c : aEntities.keySet())
        {
            if(c.equals(pC)) return aEntities.get(c);
        }

        return null;
    }

    public String toString()
    {
        return this.aDescription;
    }
} // Room

