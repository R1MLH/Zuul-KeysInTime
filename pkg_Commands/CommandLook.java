package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande look, qui permet de regarder une piece
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandLook extends Command
{

    /**
     * Constructor for objects of class CommandLook
     */
    public CommandLook()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity player)

    {
        if (!(player instanceof Player)) return ;
        
        Player vPlayer = (Player) player;
        vPlayer.look();
    }
}
