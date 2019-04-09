package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;
// package pkg_Command;
/**
 * Classe pour la commande go, qui permet de se déplacer
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandGo extends Command
{

    /**
     * Constructor for objects of class CommandGo
     */
    public CommandGo()
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
        player.getEngine().refreshTime();
        Direction pDir = Direction.getDirection(this.getSecondWord());
        if (!player.isFacing(pDir)) player.turn(pDir);
        player.move(pDir);
        player.getEngine().refreshDisplay(player);
        //         if (!this.hasSecondWord())
        //         {
        //             player.getEngine().println("Vous avancez avant de vous rendre compte de l'absence de direction de votre mouvement.");
        //             return;
        //         }
        //         String vDirection = this.getSecondWord();
        //         Room vNextRoom = player.getRoom().getExit(vDirection);
        //         Door vNextRoomDoor = player.getRoom().getDoor(vDirection);
        //         if(vNextRoomDoor == null)
        //         {
        //             player.getEngine().println("Vous avancez dans cette direction, cependant après quelques mètres vous vous apercevez qu'un mur a bloqué votre trajet. Le trajet que vous pensiez alors avoir fait n'était qu'illusion, tout n'est que question de perspective j'imagine. Ou bien pouvez vous conclure de l'existence de la direction dans laquelle vous souhaitiez aller? ");
        //             return;
        //         }// if
        //         else if ((vNextRoomDoor.isLocked() && player.isInInventory(vNextRoomDoor.getKey().getName()))||!vNextRoomDoor.isLocked())
        //         {
        // 
        //             player.moveRoom(vNextRoom);
        //             player.getEngine().printLocationInfo();
        //         }
        //         else{
        //             player.getEngine().println("la porte est bloquée");
        //         }
    }
}
