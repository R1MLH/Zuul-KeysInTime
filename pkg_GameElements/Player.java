package pkg_GameElements;
import pkg_Core.*;
// import java.util.Stack;
// import java.util.HashMap;
// import java.util.Set;
// import java.util.Iterator;
/**
 * Classe pour les personages joueurs; un type de personnage
 * 
 * @author Erwan Mailharro
 * @version 22/03/16
 */
public class Player extends Characters
{

    //     private Room aCurrentRoom;
    //     private Stack<Room> aTrajet;
    //   private ItemList aInventory;
    // private int aCarryMax;
    private int aTime;
    private GameEngine aEngine;

    /**
     * Constructeur de la classe player, avec les valeurs par défaut pour le Carry et le time
     */
    public Player(String pName,Room pRoom,GameEngine pEngine)
    {
        this(0,0,pName,pRoom,100,10,pEngine);
    }

    public Player(String pName,GameEngine pEngine)
    {
        this(0,0,pName,null,100,10,pEngine);
    }

    /**
     * Constructeur naturel de la classe Player
     */
    public Player(int pX, int pY,String pName,Room pRoom, final int pCarry, final int pTime, GameEngine pEngine)
    {
        super(pX,pY,"/player/",pName,pRoom,pCarry);
        //this.aCurrentRoom = pRoom;
        //aTrajet = new Stack<Room>();
        //         aInventory = new ItemList();
        //aCarryMax = pCarry;
        aTime = pTime;
        aEngine = pEngine;
    }
// 
//     /**
//      * Constructeur naturel de la classe Player
//      */
//     public Player(int pX, int pY,String pName, final int pCarry, final int pTime, GameEngine pEngine)
//     {
//         super("./Images/player/",pName,pCarry);
//         //this.aCurrentRoom = pRoom;
//         //aTrajet = new Stack<Room>();
//         //         aInventory = new ItemList();
//         //aCarryMax = pCarry;
//         aTime = pTime;
//         aEngine = pEngine;
//     }
//     
//         /**
//      * Constructeur naturel de la classe Player
//      */
//     public Player(int pX, int pY,String pName, final int pCarry, final int pTime, GameEngine pEngine)
//     {
//         super(pX,pY,"./Images/player/",pName,pCarry);
//         //this.aCurrentRoom = pRoom;
//         //aTrajet = new Stack<Room>();
//         //         aInventory = new ItemList();
//         //aCarryMax = pCarry;
//         aTime = pTime;
//         aEngine = pEngine;
//     }

    /**
     * retourne le GameEngine
     */
    public GameEngine getEngine()
    {return this.aEngine;
    }

    /**
     * vérifie si le joueur peut retourner en arière
     */
    public boolean canGoBack()
    {
        //return getRoom().hasExitTo(this.getTrajet().peek());
        return !(this.getTrajet().empty());
    }

    /**
     * renvoie la description de la room actuelle
     */
    public void look()
    {
        aEngine.println(getRoom().getLongDescription());
    }

    /**
     * teste si il reste des déplacements au joueur
     */
    public boolean hasTime()
    {
        if (this.aTime > 0)
        {
            this.aTime--;
            return true;
        }
        else return false;
    }

    /**
     * renvoie l'inventaire sous forme de string
     */
    public void showInventory()
    {
        aEngine.println("Inventaire : Charge :" + this.getItemList().getWeight() + "/" + this.getCarryMax() + " Objets " + this.getItemList().getItemString());
    }

    /**
     * renvoie la description de l'emplacement du joueur
     */
    public String getLocationInfo(){return this.getRoom().getLongDescription();}

    /**
     * renvoie les items présents a l'emplacement du joueur
     */
    public String getLocationItems(){return this.getRoom().getItemString();}

    /**
     * renvoie l'image de la piece ou se trouve le joueur
     */
    public String getLocationPic()
    { 
        if(this.getRoom().getImageName() != null)
            return this.getRoom().getImageName();
        else return "default";
    }

    /**
     * déplace le joueur et enregistre son trajet
     */
    public void moveRoom(Room pRoom)
    {
        // this.getTrajet().push(getRoom());
        this.setRoom(pRoom);    
        aEngine.printLocationInfo();

    }

       
    @Override public void move(pkg_Core.Direction pDir)
    {
        this.getTrajet().add(pDir);
        super.move(pDir);   
       
    }

    
    /**
     * déplace le joueur et enregistre son trajet
     */
    public void moveRoom(Coordinates pCoordinates)
    {
        // this.getTrajet().push(getRoom());
        this.delete();
        this.setLocation(pCoordinates);    
        aEngine.printLocationInfo();

    }

    public void gameOver()
    {
        this.moveRoom(new Coordinates(new Room("GAME OVER","gameover.png"),1,1));
    }
    public void interact(Entity pE)
    {
        //getEngine().println("interact fonctionne");
        if((!(this.getRoom().isLocationOccupied(this.getCoordinates(this.getDirection()))))|| this.getEntityInFront() instanceof Player) {

            return;
        }
        else 
        {   

            this.getEntityInFront().interact(this);
        }
    }

  
}

   