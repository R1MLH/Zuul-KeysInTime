package pkg_GameElements;
import java.util.Stack;
import pkg_Core.*;

/**
 * Classe pour les personnages non joueurs
 * @author Erwan Mailharro
 * @version 11/04/16
 */
public class NonPlayerCharacters extends Characters
{
    String aDialogue;

    /**
     * Constructeur naturlel de la classe NPC
     */
    public NonPlayerCharacters(String pName, Room pRoom, final int pCarry, String pDialogue)
    {
        super(4,10,pName,"",pRoom,pCarry);
        aDialogue = pDialogue;

    }

    /**
     * Constructeur naturlel de la classe NPC
     */
    public NonPlayerCharacters(String pName,Room pRoom,String pImage, final int pCarry, String pDialogue)
    {
        super(10,10,pName,"",pRoom,pCarry);
        aDialogue = pDialogue;

    }
    // 
    /**
     * Constructeur naturlel de la classe NPC
     */
    public NonPlayerCharacters(String pName,String pImage, String pDialogue)
    {
        super(10,10,pImage,pName,null,50);
        aDialogue = pDialogue;

    }

    /**
     * renvoie le dialogue du NPC
     */
    public String getText()
    {
        return this.getName() + ": "+this.aDialogue;
    }

    /**
     * permet de déplacer le npc de room
     */
    public void moveRoom(Room pRoom)
    {
        this.setRoom(pRoom);    
    }

    /**
     * renvoie la prochaine room du trajet du NPC
     */
    public Direction getNextMove()
    {

        return null;
    }

    public void interact(Entity pE)
    {
        //         CommandWord.TALK.getCommand().setSecondWord(this.aDialogue);
        //         CommandWord.TALK.getCommand().execute(pE);
        getEngine().processCommand("talk " + this.getName());
    }

    public void move()
    {
        Direction a = getNextMove();
        if(a != null)
            {this.turn(a);
            this.move(a);
        }
    }

    public void startMoving()
    {

    }

} // NonPlayerCharacters
