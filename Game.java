import pkg_Core.GameEngine;
import pkg_Core.UserInterface;
/**
 * La classe principale du jeu, qui relie le game engine avec l'interface
 * 
 * @author Erwan MAILHARRO 
 * @version 2.0 20/02/16
 */
public class Game
{
    private GameEngine aGameEngine;
    private UserInterface aGui;

    /**
     * constructeur de la classe game
     */
    public Game()
    {
        aGameEngine = new GameEngine();
        aGui = new UserInterface(aGameEngine);
        aGameEngine.setGUI(aGui);

    }//Game()

    
    public static void main( String[] pArgs )
    {
        new Game();
    }
} // Game
