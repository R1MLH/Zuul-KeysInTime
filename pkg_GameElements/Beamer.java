package pkg_GameElements;
import pkg_Core.*;
/**
 *Le beamer est un objet qui peut etre chargé, puis utilisé.
 *charger le beamer permet d'enregistrer la room actuelle
 * utiliser le beamer permet de se téléporter a la room enregistrée
 * 
 * @author Erwan Mailharro
 * @version 22/03/2016
 */
public class Beamer extends UseableItem
{
    Coordinates aSavedRoom;


    /**
     * default constructor for objects of class Beamer
     */
    public Beamer()
    {
        super("beamer","un téléporteur portable",25,"/beamer/");
        Room aSavedRoom = null;
        
    } 
    
    /**
     * enregistre la room
     * @param pRoom - la room a enregistrer
     */
    public void charge(Coordinates pRoom)
    {
        if (aSavedRoom != null) return;
        else this.aSavedRoom = pRoom;
                
    }
    
    /**
     * vérifie si le beamer est chargé
     * @return retourne vrai si le beamer est chargé
     */
    public boolean isCharged()
    {
        return !(aSavedRoom==null) ;
    }
    
    /**
     * renvoie la room enregistrée et décharge le beamer
     * @return renvoie la room enregistrée
     */
    public Coordinates beam()
    {
        Coordinates vRoom = aSavedRoom;
        aSavedRoom = null;
        return vRoom;
    }
    
    
} // Beamer

