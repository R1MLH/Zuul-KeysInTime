package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
// package pkg_Command;


/**
 * Classe pour la commande drop, qui permet de déposer un objet dans une room
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandDrop extends Command
{

    /**
     * Constructeur de la classe CommandDrop
     */
    public CommandDrop()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity pPlayer)
    {
        if(!(pPlayer instanceof Characters)) return;

        Characters player = (Characters) pPlayer;
        if (!this.hasSecondWord())
        {
            player.getEngine().println("drop what?");
            return;
        }

        if (player.isInInventory(this.getSecondWord()) && (player.getEntityInFront() == null))
        {

            player.getItem(this.getSecondWord()).setLocation(player.getCoordinates(player.getDirection()));
            player.getRoom().add(player.getItem(this.getSecondWord()));

            //player.getItemList().transferItemTo(player.getRoom().getItemList(),this.getSecondWord());
            player.getEngine().println(this.getSecondWord() + " dropped");
            player.getEngine().showEntity(player.getItem(this.getSecondWord()));
            player.removeItem((player.getItem(this.getSecondWord())));
            
            
            
        }
        else return ;
    }
}
