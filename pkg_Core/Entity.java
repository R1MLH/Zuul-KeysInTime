package pkg_Core;
/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity
{
    private Coordinates aCoordinates;
    private String aImageURL;
    //     private Room aCurrentRoom;
    private static GameEngine aEngine;
    private Direction aDir;

    /**
     * default constructor for objects of class Entity
     */
    public Entity(int pX, int pY, String pStringImage,Room pRoom)
    {
        aCoordinates = new Coordinates(pRoom,pX,pY);
        aImageURL = "/Images" + pStringImage;
        //         aCurrentRoom = pRoom;
        aDir = Direction.DOWN;
    }

    /**
     * efface l'affichage de l'entité
     */
    public void delete()
    {
        this.getRoom().remove(this);
        getEngine().eraseEntity(this);
        getEngine().refresh();  }

    /**
     * définis l'emplacement de l'entité 
     */
    public void setLocation(Room pRoom,final int pX, final int pY)
    {
        aCoordinates = new Coordinates(pRoom,pX,pY);
        //         aCurrentRoom = pRoom;
        this.placeOnGrid();
    }

    /**
     * définis l'emplacement de l'entité 
     */
    public void setLocation(Coordinates pCoordinates)
    {
        aCoordinates = pCoordinates;
        //         aCurrentRoom = pRoom;
        this.placeOnGrid();
    }

    /**
     * définit la room de l'entité
     */
    public void setRoom(Room pRoom)
    {
        this.aCoordinates.setRoom(pRoom);
        //         aCurrentRoom = pRoom;
    }

    /**
     * renvoie la room actuelle
     */
    public Room getRoom()
    {
        return this.aCoordinates.getRoom();
        //         return aCurrentRoom;
    }

    /**
     * renvoie l'image en fonction de la direction a laquelle l'entité fait face
     */
    public String getImage()
    {
        switch(aDir){ 
            case UP :
            //             System.out.println(this.aImageURL + "up.png");
            return this.aImageURL + "up.png";
            case DOWN:
            //             System.out.println(this.aImageURL + "down.png");
            return this.aImageURL + "down.png";
            case LEFT:
            //             System.out.println(this.aImageURL + "left.png");
            return this.aImageURL + "left.png";
            case RIGHT: 
            //             System.out.println(this.aImageURL + "right.png");
            return this.aImageURL + "right.png";
            default : return this.aImageURL +"default.png";
        }}

    /**
     * renvoie une coordonée x ou y
     */
    public int getCoordinate(String pS)
    {
        return aCoordinates.getCoordinate(pS);
    }

    /**
     * renvoie les coordonées converties en visuelles
     */
    public int getVCoordinate(String pS)
    {
        return aCoordinates.getVisual(pS);
    }
    
    /**
     * renvoie les coordonées
     */
    public Coordinates getCoordinates()
    {
        return this.aCoordinates;
    }

    /**
     * renvoie les coordonées adjacentes dans la direction en paramètre
     */
    public Coordinates getCoordinates(Direction pDir)
    {
        return this.aCoordinates.getCoordinates(pDir);
    }

    /**
     * ajoute l'entité dans sa room actuelle
     */
    public void placeOnGrid()
    {
        this.aCoordinates.getRoom().add(this);
    }

    /**
     * déplace l'entité
     */
    public void move(Direction pDir)
    {
        if(!(this.getRoom().isLocationOccupied(this.getCoordinates(this.getDirection())))) {
            //             System.out.println(this.aCoordinates);
            aCoordinates.move(pDir);

            //             System.out.println(this.aCoordinates);
        }
        else turn(pDir);

        //aEngine.refreshDisplay(this);
    }

    /**
     * vérifie si l'entité est tourné dans la direction en paramètre
     */
    public boolean isFacing(Direction pDir)
    {
        return pDir == aDir;
    }

    /**
     * renvoie la direction
     */
    public Direction getDirection()
    {
        return this.aDir;
    }

    /**
     * définit le GameEngine
     */
    public static void setEngine(GameEngine pE)
    {
        aEngine = pE;
    }

    /**
     * tourne l'entité
     */
    public void turn(Direction pDir)
    {
        aDir = pDir;
    }

    /**
     * définit l'interaction avec le player
     */
    public abstract void interact(Entity pE);

    /**
     * renvoie le GameEngine
     */
    public GameEngine getEngine()
    {
        return aEngine;
    }

} // Entity
