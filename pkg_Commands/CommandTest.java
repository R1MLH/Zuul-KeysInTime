package pkg_Commands;
import pkg_Core.*;
import pkg_GameElements.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
/**
 * Classe pour la commande test, qui permet de lire un fichier de commandes
 * 
 * @author  Erwan Mailharro
 * @version 10/04/16
 */
public class CommandTest extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CommandTest
     */
    public CommandTest()
    {

    }

    /**
     * Permet d'executer la commande 
     * @param  player décrit le player qui execute l'action
     */
    public void execute(Entity player)
    {
        Thread safe = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try
                        {
                            Scanner sr = new Scanner( new File(getSecondWord()));
                            Robot robot = new Robot();
                            robot.setAutoDelay(40);
                            robot.setAutoWaitForIdle(true);
                            while (sr.hasNextLine())
                            {
                                String str = sr.nextLine();

                                
                                byte[] bytes = str.getBytes();
                                for (byte b : bytes)
                                {
                                    int code = b;
                                    
                                    if (code > 96 && code < 123) code = code - 32;

                                    robot.keyPress(code);
                                    robot.keyRelease(code);

                                }
                              
                            }}
                        catch( Exception FileNotFoundException)
                        {
                            player.getEngine().println("url invalide");
                        }
                        

                    }
                });

        if (!this.hasSecondWord())
        {
            player.getEngine().println("error");
            return;
        }
        else
        {
            safe.start();
        }
    }
}