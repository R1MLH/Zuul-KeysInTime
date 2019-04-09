package pkg_GameElements;
import pkg_Core.*;
import java.util.Stack;

/**
 * Abstract class Characters - Classe regroupant tous les types de personnages , joueurs et non joueurs
 * 
 * @author Erwan Mailharro
 * @version 10/04/16
 */
public abstract class Characters extends Entity
{
    private String aName;
    //private Room aCurrentRoom;
    private Stack<Direction> aTrajet;
    private ItemList aInventory;
    private int aCarryMax;

    /**
     * Constructeur de la classe characters
     */
    public Characters(final int pX,final int pY,String pImage,String pName,Room pRoom,final int pCarry)
    {
        super(pX,pY,pImage,pRoom);
        aName = pName;
        //this.aCurrentRoom = pRoom;
        this.aTrajet = new Stack<Direction>();
        aInventory = new ItemList();
        aCarryMax = pCarry;
    }
    // 
    //     /**
    //      * Constructeur de la classe characters
    //      */
    //     public Characters(String pImage,String pName,final int pCarry)
    //     {
    //         super(1,1,pImage,null);
    //         aName = pName;
    //         //this.aCurrentRoom = pRoom;
    //         this.aTrajet = new Stack<Coordinates>();
    //         aInventory = new ItemList();
    //         aCarryMax = pCarry;
    //     }

    public String toString()
    {
        return this.getName();
    }

    /**
     * renvoie le nom
     */
    public String getName()
    {
        return this.aName;
    }

    /**
     * renvoie l'item correspondant a la string
     */
    public Item getItem(String pName)
    {
        return this.aInventory.getItem(pName);
    }

    /**
     * renvoie le Trajet
     */
    public Stack<Direction> getTrajet()
    {return this.aTrajet;}

    //     public Room getRoom()
    //     {return this.aCurrentRoom;}

    /**
     * ajoute un item dans l'inventaire
     */
    public void addItem(Item pItem)
    {        this.aInventory.addItem(pItem);
    }

    public void removeItem(Item pItem)
    {
        this.aInventory.removeItem(pItem);
    }
    
    /**
     * vérifie si l'objet est dans l'inventaire
     */
    public boolean isInInventory(String pString)
    { return this.aInventory.containsItem(pString);
    }

    /**
     * téléporte le personnage dans la room
     */
    @Override public void setRoom(Room pRoom)
    {
        if(this.getRoom() != null ) this.getRoom().removeCharacter(this);
        super.setRoom(pRoom);
        this.getRoom().add(this);
    }

    public abstract void moveRoom(Room pRoom);

    /**
     * renvoie le Carry
     */
    public int getCarryMax()
    {return this.aCarryMax;}

    /**
     * renvoie l'inventaire
     */
    public ItemList getItemList()
    {
        return this.aInventory;
    }

    /**
     * permet d'ajouter le carry
     */
    public void addCarryMax(final int bonus)
    {this.aCarryMax += bonus;
    }

    /**
     * permet de définir le trajet
     */
    public void setTrajet(Stack<Direction> pTrajet)
    {
        this.aTrajet = pTrajet;
    }

      public Entity getEntityInFront()
    {
        return this.getRoom().getEntity(this.getCoordinates(this.getDirection()));
    }
    
    @Override public void move(pkg_Core.Direction pDir)
    {
//         this.aTrajet.add(pDir);
        super.move(pDir);   
        this.getEngine().refreshDisplay(this);
    }
    
    public void reverse(Direction pDir)
    {
        super.move(pDir.getReverse());
        this.turn(pDir);
    }
}
