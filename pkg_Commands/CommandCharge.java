package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
// package pkg_Command;
/**
 * Classe pour la commande charge, qui permet de charger le beamer 
 * 
 * inutile dans la dernière version
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandCharge extends Command
{

    /**
     * Constructor for objects of class CommandCharge
     */
    public CommandCharge()
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
        if(!this.hasSecondWord()) player.getEngine().println("charge what?");
        else if (!this.getSecondWord().equals("beamer")) player.getEngine().println("cant charge that");
        else if(!player.isInInventory("beamer"))player.getEngine().println("no beamer to charge");
        else 
        {
            Beamer vBeamer = (Beamer) player.getItemList().getItem("beamer");
            vBeamer.charge(player.getCoordinates());
            //             this.aInventory.removeItem("beamer");
            //             this.aInventory.addItem(vBeamer);
            player.getEngine().println("Beamer ready");

        }
    }
}
