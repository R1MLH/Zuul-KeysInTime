package pkg_Commands;
import pkg_Core.*;

// import pkg_Command.*;
/**
 * This class is an abstract superclass for all command classes in the game.
 * Each user command is implemented by a specific command subclass.
 *
 * Objects of class Command can store an optional argument word (a second
 * word entered on the command line). If the command had only one word, 
 * then the second word is <null>.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */

public abstract class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command()
    {
        aSecondWord = null;
    }

    /**
     * Constructeur naturel de la classe Command
     */
    public Command(final CommandWord pCommandWord,final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }//Command()

    /**
     * getter de l'attribut commandword
     */
    public CommandWord getCommandWord()
    {
        return this.aCommandWord;
    }//getCommandword

    /**
     * getter de l'attribut secondword
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondword

    /**
     * Test si il y a un second mot
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }// hasSecondWord

    /**
     * test si le premier mot est connu
     */
    public boolean isUnknown()
    {
        return aCommandWord == CommandWord.UNKNOWN;
    }//isUnknown
    
        /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract void execute(Entity player);

        /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String secondWord)
    {
        this.aSecondWord = secondWord;
    }
} // Command
