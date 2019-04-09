package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
/**
 * Classe pour la commande use, qui permet d'utiliser les objets utilisables
 * 
 * 
 * @author  Erwan Mailharro
 * @version 05/06/16
 */
public class CommandUse extends Command
{

    /**
     * Constructor for objects of class CommandUse
     */
    public CommandUse()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity pPlayer)
    {
        if(!(pPlayer instanceof Characters)) return;

        Player player = (Player) pPlayer;
        if(!this.hasSecondWord()) {
            player.getEngine().println("use what ?");
            return ;
        }
        Item vItem = player.getItemList().getItem(this.getSecondWord());
        if (!(vItem instanceof UseableItem)) return;
        else if(vItem instanceof Beamer) 
        {
            Beamer vBeamer = (Beamer) vItem;
            if (vBeamer.isCharged())
            {
                Coordinates pC = vBeamer.beam();
                player.moveRoom(pC);
                
                player.getEngine().printLocationInfo();
            }
            else {
                vBeamer.charge(player.getCoordinates());
                player.getEngine().println("Beamer ready");
            }
        }
        else if( vItem instanceof Food) 
        {

            Food vFood = (Food) vItem;
            player.addCarryMax(vFood.getBonus());

            player.getItemList().removeItem(this.getSecondWord());
            player.getEngine().println("Vous vous sentez plus fort"); 
        }
    }
}