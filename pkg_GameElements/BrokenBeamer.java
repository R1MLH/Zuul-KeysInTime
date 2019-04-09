package pkg_GameElements;
import pkg_Core.*;

/**
 * BrokenBeamer - Le beamer cassé est comme un beamer normal , sauf qu'il renvoie une room aléatoire
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrokenBeamer extends Beamer
{
    /**
     * Constructeur de la classe BrokenBeamer
     */
    public BrokenBeamer()
    {
        super();
    }

    /**
     * renvoie une room aléatoire au lieu de la room enregistrée
     */
    @Override public Coordinates beam()
    {
        //         return RoomRandomizer.getRandomRoom();
        return null;
    }
} // BrokenBeamer

