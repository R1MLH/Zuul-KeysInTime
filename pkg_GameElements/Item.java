package pkg_GameElements;
import pkg_Core.Entity;
/**
 * Les objets du jeu
 * 
 * @author Erwan MAILHARRO 
 * @version 27/02/2016
 */
public class Item extends Entity
{
    // instance variables - replace the example below with your own
    private String aDescription;
    private int aWeight;
    private String aName;

    /**
     * Constructor for objects of class Item
     */
    public Item(String pName,String pDescription,final int pWeight,String pImage)
    {
        super(1,1,"/Item"+pImage,null);
        this.aName = pName;
        this.aDescription = pDescription;
        this.aWeight = pWeight;

    }

    public Item()
    {this("item","default",0,"");}

    /**
     * renvoie le poids de l'objet 
     */
    public int getWeight(){return this.aWeight;}

    /**
     * renvoie la description de l'objet
     */
    public String getDescription(){return this.aDescription;}

    /**
     * renvoie le nom de l'objet 
     */
    public String getName(){return this.aName;}
    
    public void interact(Entity pE)
    {
        pE.getEngine().processCommand("take " + this.getName());
    }
}
