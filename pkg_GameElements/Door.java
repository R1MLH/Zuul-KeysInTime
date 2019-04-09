package pkg_GameElements;
import pkg_Core.*;
/**
 * La classe porte corresponds aux portes d'une piece.
 * 
 * Une porte permet d'accéder a une sortie d'une piece.
 * 
 * @author Erwan Mailharro 
 * @version 20/03/16
 */
public class Door extends Entity
{
    private boolean Locked;
    private Item aKey;
    private String aDir;
    private Coordinates aDestination;

    /**
     * constructeur pour les portes dévérouillées
     */
    public Door(int pX, int pY,Room pR,Room pD,int pXD, int pYD,String pImage) 
    {
        super(pX,pY,"/Door/"+pImage,pR);
        this.Locked = false;
        this.aKey = null;
        aDir= "dir";
        this.aDestination = new Coordinates(pD,pXD,pYD);
    }

    /**
     * Constructeur pour les portes vérouillées avec une clé en paramètre
     */
    public Door(int pX, int pY,Room pR,Room pD,int pXD, int pYD,Item pKey,String pImage)
    {
        super(pX,pY,"/Door/"+pImage,pR);
        this.Locked = true;
        this.aKey = pKey;
        aDir = "dir";
        this.aDestination = new Coordinates(pD,pXD,pYD);
    }

    /**
     * vérifie si la porte est vérouillée
     */
    public boolean isLocked()
    {
        return this.Locked;
    }

    public Coordinates getDestination()
    {
        return this.aDestination.dupe();
    }

    /**
     * renvoie la clé
     */
    public Item getKey()
    {
        return this.aKey;
    }
    
    public String getMessage()
    {
        return "la porte est vérouillée";
    }

    public void interact(Entity pE)
    {
        if(!(pE instanceof Player)) return;
        Player player = (Player) pE;
        if (this.isLocked() && player.isInInventory(this.getKey().getName())||(!this.isLocked()))
        {Player vE = (Player) pE;
            vE.moveRoom(this.getDestination());
        }
        else player.getEngine().println(this.getMessage());}
    }
