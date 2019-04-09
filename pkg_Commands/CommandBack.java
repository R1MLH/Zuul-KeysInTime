package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande back, qui permet de retourner en arrière
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandBack extends Command
{

    /**
     * Constructor for objects of class CommandBack
     */
    public CommandBack()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity pPlayer)
    {
        if(!(pPlayer instanceof Player)) return;
        Player player = (Player) pPlayer;
        if ( player.canGoBack())
        {
            player.reverse(player.getTrajet().pop());
            player.getEngine().refreshDisplay(player);
        }

    }
}
