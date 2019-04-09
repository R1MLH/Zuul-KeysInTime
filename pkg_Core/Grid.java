package pkg_Core;
import pkg_GameElements.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid
{
    private HashMap<Coordinates,Entity> Locations;
    public static final int GRIDSCALE = 33;

    /**
     * default constructor for objects of class Grid
     */
    public Grid(int pX, int pY)
    {
        Locations = new HashMap<Coordinates,Entity>();

        for (int i = -1; i<=pX; i++)
        {this.add(new Terrain(i,-1));
            this.add(new Terrain(i,pY));}
        for (int i = -1; i<31;i++)
        {this.add(new Terrain(-1,i));
            this.add(new Terrain(pX,i));}
        this.add(new Terrain(0,2));
        this.add(new Terrain(1,2));
        this.add(new Terrain(2,2));
        this.add(new Terrain(2,1));
        this.add(new Terrain(2,0));
    } 

    /**
     * ajoute une entité a la grille
     */
    public void add(Entity pEntity)
    {
        Locations.put(pEntity.getCoordinates(),pEntity);
    }

    /**
     * enleve une entité de la grille
     */
    public void remove(Entity pEntity)
    {
        Set<Coordinates> key = Locations.keySet();
        for(Iterator<Coordinates> it = key.iterator(); it.hasNext() ;)
        {if (it.next().equals(pEntity.getCoordinates())) it.remove();
            
        }
    }

    /**
     * vérifie si l'emplacement est occupé
     */
    public boolean isLocationOccupied(Coordinates pCoordinates)
    {
        boolean vReturn= false;

        Set<Coordinates> keys = Locations.keySet();
        for(Coordinates i : keys) {
            if ( i.equals(pCoordinates) ) vReturn = true;
        }

        return vReturn;
    }
} // Grid

