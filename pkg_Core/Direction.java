package pkg_Core;
/**
 * Enumeration class Direction - Cette classe sert a définir les directions sur un plan en 2D
 * Ces Directions permettent des interactions et des déplacement simplifiés entre les entités
 * 
 * @author Erwan Mailharro
 * @version 22-5-16
 */
public enum Direction
{
    UP("up"),

    DOWN("down"),

    LEFT("left"),

    RIGHT("right");
    
    private String aDirectionString;
    
    Direction(String pDirStr)
    {
        aDirectionString = pDirStr;
    }

    public String toString()
    {
        return aDirectionString;
    }

    /**
     * renvoie la direction correspondant à la string
     */
    public static Direction getDirection(String pStr)
    {

        for(Direction dir : Direction.values())
        {
            if (pStr.equals(dir.toString())) return dir;
        }
        return null;
    }

    /**
     * renvoie la direction opposée
     */
    public Direction getReverse()
    {
        switch (this)
        {
            case UP: return DOWN;
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case DOWN: return UP;
            default: return null;
        }
    }
}
