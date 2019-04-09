package pkg_GameElements;
import java.util.Random;
import pkg_Core.*;
/**
 * Write a description of class TransporterDoor here.
 * 
 * @author Erwan MAILHARRO
 * @version 02-06-16
 */
public class TransporterDoor extends Door
{
    Coordinates[] possibleDestinations;
    /**
     * Constructor for objects of class TransporterDoor
     */
    public TransporterDoor(int pX, int pY,Room pR,Room pD,int pXD, int pYD,String pI)
    {
        super(pX,pY,pR,pD,pXD,pYD,pI);
    }

    public TransporterDoor(int pX, int pY,Room pR,Room pD,int pXD, int pYD,Item pKey,String pI)
    {
        super(pX,pY,pR,pD,pXD,pYD,pKey,pI);
    }

    public void setPossibleDestinations(Coordinates[] pTab)
    {
        this.possibleDestinations = pTab;
    }
    
    @Override public Coordinates getDestination()
    {
        Random rand = new Random();
        
        return possibleDestinations[rand.nextInt(possibleDestinations.length)].dupe();
    }

}
