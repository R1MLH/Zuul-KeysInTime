package pkg_Commands;

import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande inventaire, qui permet d'afficher l'inventaire
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandInventaire extends Command
{

    /**
     * Constructor for objects of class CommandInventaire
     */
    public CommandInventaire()
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
        player.showInventory();
    }
}
