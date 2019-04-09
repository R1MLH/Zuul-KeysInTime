package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande talk, qui permet de parler a un NPC
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandTalk extends Command
{

    /**
     * Constructor for objects of class CommandTake
     */
    public CommandTalk()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity player)
    {
        if (!this.hasSecondWord())
        {
            player.getEngine().println("talk to who ?");
            return;
        }

        if (player.getRoom().isCharInRoom(this.getSecondWord()) && ! (player.getRoom().getChar(this.getSecondWord())instanceof Player)) 
        {
            NonPlayerCharacters vNPC = (NonPlayerCharacters)player.getRoom().getChar(this.getSecondWord());
            player.getEngine().println(vNPC.getText());
        }
        else if (player.getRoom().isCharInRoom(this.getSecondWord()) &&  (player.getRoom().getChar(this.getSecondWord())instanceof Player)) 
        {
            player.getEngine().println("la folie vous guette");
        }
        else player.getEngine().println("vous ne pouvez pas parler a ca");
    }
}
