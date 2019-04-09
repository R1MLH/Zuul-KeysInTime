package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande take, qui permet de prendre un objet dans une room
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandTake extends Command
{

    /**
     * Constructor for objects of class CommandTake
     */
    public CommandTake()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity player)
    {
        if(!(player instanceof Characters)) return;

        Characters vPlayer = (Characters) player;
        if (!this.hasSecondWord())
        {
            vPlayer.getEngine().println("take what?");
            return;
        }

        if (vPlayer.getRoom().isItemInRoom(this.getSecondWord()) && vPlayer.getItemList().getWeight()+ vPlayer.getRoom().getItem(this.getSecondWord()).getWeight() <= vPlayer.getCarryMax())
        {
            
            vPlayer.getRoom().getItem(this.getSecondWord()).delete();
            vPlayer.getRoom().getItemList().transferItemTo(vPlayer.getItemList(),this.getSecondWord());
          
            vPlayer.getEngine().println(this.getSecondWord() + " taken");

        }
        else vPlayer.getEngine().println("vous ne pouvez pas prendre ça");
    }
}
