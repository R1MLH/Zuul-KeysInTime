
package pkg_Commands;
/**
 * Enumeration class CommandWord - correspond a la liste des commandes
 * 
 * @author Erwan MAILHARRO
 * @version 09/03/16
 */
public enum CommandWord
{
    GO("go", new CommandGo()), QUIT("quit", new CommandQuit()), HELP("aide", new CommandHelp()), LOOK("look",new CommandLook()), EAT("eat",new CommandEat()), BACK("back", new CommandBack()), TEST("test", new CommandTest()), TAKE("take", new CommandTake()), DROP("drop", new CommandDrop()), INVENTAIRE("inventaire", new CommandInventaire()), UNKNOWN("?",new CommandUnknown()), CHARGE("charge",new CommandCharge()), USE("use",new CommandUse()), ALEA("alea", new CommandAlea()),TALK("talk", new CommandTalk());

    private String aCommandString;
    private Command aCommandObject;
    
    CommandWord(String pCommandString, Command pCommand)
    {this.aCommandString = pCommandString;
    this .aCommandObject = pCommand;}
    
    public String toString()
    {return this.aCommandString;}
    
    public Command getCommand()
    {
        return (Command) this.aCommandObject;
    }
}

