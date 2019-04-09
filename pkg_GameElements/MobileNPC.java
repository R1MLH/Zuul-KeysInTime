package pkg_GameElements;
import pkg_Core.Direction;
import java.util.Stack;
/**
 * Write a description of class MobileNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MobileNPC extends NonPlayerCharacters
{
    Stack<Direction> aBackTrajet;

    /**
     * Constructor for objects of class MobileNPC
     */
    public MobileNPC(String pName,String pImage, String pDialogue)
    {
        super(pName,pImage,pDialogue);
        aBackTrajet = new Stack<Direction>();
    }

    @Override public Direction getNextMove()
    {
        if(this.getTrajet().empty())
        {
            this.setTrajet(this.aBackTrajet);
            aBackTrajet = new Stack<Direction>();
        }
      
        this.aBackTrajet.push(this.getTrajet().peek());
            return  this.getTrajet().pop();
        
            }
    }
