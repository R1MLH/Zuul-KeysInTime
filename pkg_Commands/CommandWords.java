package pkg_Commands;

import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    private HashMap<String, CommandWord> aValidCommands;
// tableau constant qui contient tous les mots de commande valides
//     private static final String[] sValidCommands = {
//             "go", "quit", "help","look","eat","back","test","take","drop","inventaire"
//         };

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        aValidCommands = new HashMap<String, CommandWord>();
        for(CommandWord command: CommandWord.values()){
            if(command != CommandWord.UNKNOWN) {
                aValidCommands.put(command.toString(),command);
            }
        }
    } // CommandWords()

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = aValidCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString )
    {
        return aValidCommands.containsKey(pString);
    } // isCommand()

    /**
     * print all valid commands
     */
    public String getCommandList()
    {
        String vReturnString = "";

        for(String command :aValidCommands.keySet()) {
            vReturnString +=(command + " ");

        }
        return vReturnString;
    }

} // CommandWords