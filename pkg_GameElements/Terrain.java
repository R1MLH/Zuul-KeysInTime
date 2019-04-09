package pkg_GameElements;
import pkg_Core.*;
/**
 * Write a description of class Terrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terrain extends Entity
{
    // instance variables :
    /**
     * default constructor for objects of class Terrain
     */
    public Terrain(int pX, int pY,String pStringImage,Room pRoom)
    {
        super(pX,pY,pStringImage,pRoom);

    } 

    public Terrain(int pX, int pY)
    {
        this(pX,pY,null,null);
    }
    
        public void interact(Entity pE)
    {
        
    }
} // Terrain

