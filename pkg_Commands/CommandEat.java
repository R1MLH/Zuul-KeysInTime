package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande eat, qui permet de manger des objets de type food
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandEat extends Command
{

    /**
     * Constructor for objects of class CommandEat
     */
    public CommandEat()
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
        if (!this.hasSecondWord())  {
            player.getEngine().println("eat what?");
            return;}

            
       
        if(player.isInInventory(this.getSecondWord()) && player.getItemList().getItem(this.getSecondWord()) instanceof Food) 
        {

            Food vFood = (Food) player.getItemList().getItem(this.getSecondWord());
            player.addCarryMax(vFood.getBonus());

            player.getItemList().removeItem(this.getSecondWord());
            player.getEngine().println("Vous vous sentez plus fort"); 
        }
        else player.getEngine().println("Ce n'est pas comestible");
    }
}
