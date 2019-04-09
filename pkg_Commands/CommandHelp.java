package pkg_Commands;
import pkg_Core.*;
/**
 * Classe pour la commande help, qui permet d'afficher l'aide
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandHelp extends Command
{

    /**
     * Constructor for objects of class CommandHelp
     */
    public CommandHelp()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity player)
    {
        player.getEngine().printHelp();
    }
}
