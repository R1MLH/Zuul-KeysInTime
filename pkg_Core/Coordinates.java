package pkg_Core;
/**
 * Write a description of class Coordinates here.
 * 
 * @author Erwan Mailharro 
 * @version 28/03/16
 */
public class Coordinates
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Room aRoom;
    /**
     * Constructor for objects of class Coordinates
     */
    public Coordinates(Room pRoom,int pX,int pY)
    {
        // initialise instance variables
        aRoom = pRoom;
        x = pX;
        y = pY;
    }
    
    public Coordinates(Coordinates pDupe)
    {
        x= pDupe.getCoordinate("x");
        y= pDupe.getCoordinate("y");
        aRoom = pDupe.getRoom();
    }
    
    /**
     * vérifie l'égalité de coordonées
     */
    public boolean equals(Object pObj)
    {
        if (!(pObj instanceof Coordinates)) return false;
        else
        {
            Coordinates vObj = (Coordinates) pObj;
            return ((this.x == vObj.x) && (this.y == vObj.y));
        }

    }

    /**
     * retourne la coordonnée x ou y
     */
    public int getCoordinate(String pC)
    {
        if(pC.equals("x")) return this.x;
        else if (pC.equals("y")) return this.y;
        else return -1;
    }

    /**
     * renvoie les coordonées a l'échelle de l'interface
     */
    public int getVisual(String pC)
    {
        return getCoordinate(pC)*Grid.GRIDSCALE;
    }

    /**
     * renvoie les coordonées adjacentes dans la direction donnée
     */
    public Coordinates getCoordinates(Direction pDir)
    {
        if( pDir == Direction.UP)return new Coordinates(aRoom,x,y-1);
        else if (pDir == Direction.LEFT) return new Coordinates (aRoom,x-1,y);
        else if (pDir == Direction.DOWN) return new Coordinates (aRoom,x,y+1);
        else if (pDir == Direction.RIGHT) return new Coordinates (aRoom,x+1,y);
        else return this;
    }

    /**
     * déplace dans une direction
     */
    public void move(Direction pDir)
    {
        if(pDir == Direction.RIGHT)  x++;
        else if(pDir == Direction.LEFT) x--;
        else if(pDir == Direction.UP) y--;    
        else if(pDir == Direction.DOWN)y++;

    }
    
    /**
     * renvoie la room
     */
    public Room getRoom()
    {
        return this.aRoom;
    }
    
    public String toString()
    {
        return (aRoom + "x:" + x + "   y:" + y);
    }
    
    /**
     * change la room
     */
    public void setRoom(Room pRoom)
    {
        this.aRoom = pRoom;
    }
    
    /**
     * crée un nouvel objet identique a l'objet courrant
     */
    public Coordinates dupe()
    {
        return new Coordinates(this);
    }
}
