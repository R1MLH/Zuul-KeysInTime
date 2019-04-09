package pkg_GameElements;
import pkg_Core.*;
/**
 * Une Room qui téléporte le joueur de manière aléatoire dans le jeu.
 * 
 * @author Erwan Mailharro 
 * @version 22/03/16
 */
public class TransporterRoom extends Room
{
    Room aRig;
    /** 
     * Constructeur Naturel de la classe 
     */
    public TransporterRoom(final String pDescription, String pImage)
    {
        super(pDescription,pImage);
        aRig = null;
    }// Room(pDescription)

    /**
     * Override le getExit pour renvoyer une room aléatoire 
     */
    @Override public Room getExit(String pDirection){return randomRoom();}
    
    /**
     * renvoie une room aléatoire parmis les sorties, ou renvoie la piece forcée
     */
    public Room randomRoom()
    {
     //   if (aRig == null)return RoomRandomizer.getRandomRoom(this.getExitMap());
        return aRig;
    }
    
    /**
     * permet de forcer randomRoom() a renvoyer une piece spécifique
     */
    public void rig(Room pRoom)
    {
        aRig = pRoom;
    }
}
    
