package pkg_Commands;
import pkg_Core.*;
/**
 * Classe pour la commande quit, qui permet de quitter le jeu
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandQuit extends Command
{

    public CommandQuit()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity player)
    {
        if (this.hasSecondWord())
        {
            player.getEngine().println("TU VEUX QUITTER QUOI ?");
            return ;}
        else ;
        //    player.getEngine().disableGui();
    }
}
