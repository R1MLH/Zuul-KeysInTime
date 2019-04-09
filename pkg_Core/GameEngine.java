package pkg_Core;
import pkg_GameElements.*;
import pkg_Commands.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
// import pkg_Command.*;
/**
 * Cette classe représente le moteur du jeu; 
 * elle initialise le monde, et relie les les classes a l'interface.
 * 
 * 
 * @author Erwan Mailharro   
 * @version 10/04/16
 */
public class GameEngine
{
    private Parser aParser;
    private UserInterface aGui;
    private static ArrayList<NonPlayerCharacters> npcs;
    private static ArrayList<Room> aRoomList;
    private Player aPlayer;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        aRoomList = new ArrayList<Room>();
        npcs = new ArrayList<NonPlayerCharacters>();
        aParser = new Parser();
        createRooms();
        Entity.setEngine(this);

    }

    /**
     * initialise le User Interface
     */
    public void setGUI(UserInterface pUserInterface)
    {
        aGui = pUserInterface;
        //         aGui.showEntity(aPlayer);
        //aGui.showRoom(aPlayer.getRoom());
        printWelcome();
    }

    /**
     * Initialise les rooms , les objets, les personnages
     */
    private void createRooms()
    {

        //partie 1 : créer les rooms et initialisation de la arraylist
        Room present = new Room("Le present, la maison","present.png");
        Room faille = new Room("Un endroit étrange ou le temps n'a l'air d'avoir aucun sens","faille.png");
        Room prehistoire = new Room("Une jungle peuplée de dinosaures...","prehistoire.png");
        Room japon = new Room("L'époque des samurai","japon.png");
        Room victoire = new Room("DE RETOUR A LA MAISON!","present2.png");
        Room temple = new Room("Un temple shinto","temple.png");
        Room moyenage = new Room("Une ville médiévale","moyenage.png");
        Room maison = new Room("Une maison","maison.png");
        Room faille2 = new Room("???","faille2.png");

        //Création du terrain
        for(int i=0; i<15;i++)
        {prehistoire.add(new Terrain(0,i));
        }
        for (int i = 6;i<13;i++)
        {prehistoire.add(new Terrain(23,i));
        }

        for(int i=0; i<25;i++)
        {japon.add(new Terrain(30,i));
            japon.add(new Terrain(8,i));
            prehistoire.add(new Terrain(i-1,6));
            prehistoire.add(new Terrain(i-1,12));
        }
        for (int i=0;i<33;i++)
        {
            prehistoire.add(new Terrain(i+6,23));
        }

        for(int i=0; i<3;i++)
        {
            prehistoire.add(new Terrain(i+4,13));
            prehistoire.add(new Terrain(i+7,13));
            prehistoire.add(new Terrain(4,i+13));
            prehistoire.add(new Terrain(i,15));
            prehistoire.add(new Terrain(i+2,15));
            prehistoire.add(new Terrain(i+36,16));
            prehistoire.add(new Terrain(36,16+i));
            moyenage.add(new Terrain(12+i,2));
            moyenage.add(new Terrain(15+i,2));
            moyenage.add(new Terrain(18+i,2));
            moyenage.add(new Terrain(12+i,7));
            moyenage.add(new Terrain(15+i,7));
            moyenage.add(new Terrain(18+i,7));
            moyenage.add(new Terrain(12,2+i));
            moyenage.add(new Terrain(12,5+i));
            moyenage.add(new Terrain(20,2+i));
            moyenage.add(new Terrain(20,5+i));

        }

        for(int i=0; i<3;i++)
        {
            prehistoire.add(new Terrain(i+34,19));
            prehistoire.add(new Terrain(i+32,20));
            prehistoire.add(new Terrain(31+i,22-i));
        }

        //Création des items 

        Item katana = new Item("Katana","Un katana de très bonne qualitée",30,"/katana/");
        Item cle = new Item("Clé","Les clés de la machine!",10,"/cle/");
        Food tomate = new Food("Tomate","Une tomate bien juteuse",12,"/tomate/");
        Beamer vBeam = new Beamer();
        Food tomate1 = new Food("tomate","Une tomate bien juteuse",12,"/tomate/");
        Food tomate2 = new Food("Tomate","Une tomate bien juteuse",12,"/tomate/");

        tomate1.setLocation(present,4,1);
        tomate2.setLocation(present,4,2);
        tomate.setLocation(moyenage,28,20);
        vBeam.setLocation(faille2,4,1);
        katana.setLocation(temple,28,10);
        cle.setLocation(maison,12,12);

        //Créations des Trajets pour les pnj mobiles
        Stack<Direction> pTraj = new Stack<Direction>();
        pTraj.push(Direction.UP);
        pTraj.push(Direction.LEFT);
        pTraj.push(Direction.DOWN);
        pTraj.push(Direction.RIGHT);
        //Création des Characters (et du player)
        this.aPlayer = new Player("Jean-Claude",this); 
        aPlayer.setLocation(present,4,11);

        NonPlayerCharacters robert = new NonPlayerCharacters("Robert","/NPC/robert/","Bonne chance!");
        robert.setLocation(present,8,5);
        NonPlayerCharacters philipe = new NonPlayerCharacters("Philipe","/NPC/philipe/","C'est le grand jour ! L'Homme va enfin voyager dans le temps !"); 
        philipe.setLocation(present,14,5);

        NonPlayerCharacters samurai = new NonPlayerCharacters("Samurai","/NPC/samurai/","Laissez moi méditer.")
            {

                @Override public String getText()
                {
                    if(aPlayer.isInInventory(katana.getName())){ 
                        aPlayer.gameOver();
                        return this.getName()+ ": "+"C'est mon katana! Sale voleur! RYUU GA WAGA TEKI WO KURAU!";
                    }else
                        return super.getText();
                }
            };
        samurai.setLocation(japon,12,8);
        samurai.turn(Direction.LEFT);

        NonPlayerCharacters kid = new NonPlayerCharacters("Enfant","/NPC/enfant/","Il parait que le vieil homme dans la maison est un collectionneur de katana");
        kid.setLocation(moyenage,8,6);

        MobileNPC dino = new MobileNPC("Dinosaure","/NPC/dino/","GROAAAAAAAR")
            {
                @Override public String getText()
                {

                    aPlayer.gameOver();
                    return super.getText();
                }

            };
        dino.setTrajet(pTraj);
        dino.setLocation(prehistoire,31,8);
        NonPlayerCharacters vieu = new NonPlayerCharacters("Vieillard","/NPC/robert/","C'est un magnifique katana que vous avez là !")            {
                @Override public String getText()
                {
                    dino.setLocation(moyenage,31,8);
                    return super.getText();
                }

            };;
        vieu.setLocation(maison,26,12);
        //Création des portes
        Door vMachine1 = new Door(25,11,present,faille,19,4,"machine/");
        Door vMachiner = new Door(19,3,faille,victoire,1,1,cle,"machine/")
            {
                @Override public String getMessage()
                {
                    return "Vous avez perdu les clés dans le vortex spatiotemporel! retrouvez les pour rentrer chez vous.";
                }

            };

        Door vFP = new Door(7,11,faille,prehistoire,4,4,"vortex/");
        Door vFM = new Door(19,19,faille,moyenage,4,11,"vortex/");
        Door vFJ = new Door(30,11,faille,japon,16,21,"vortex/");
        Door vPF2 = new Door(4,3,prehistoire,faille2,20,12,"vortex/");
        Door vJF2 = new Door(16,22,japon,faille2,20,12,"vortex/");
        Door vMF2 = new Door(3,11,moyenage,faille2,20,12,"vortex/");

        Door vJT = new Door(30,10,japon,temple,8,10,"door/");
        Door vTJ = new Door(7,10,temple,japon,29,10,"door/");
        Door vMaM= new Door(15,7,moyenage,maison,20,20,katana,"door/")
            {
                @Override public String getMessage()
                {
                    return "Vieillard: Restez dehors!";
                }

            };

        Door vMMa= new Door(20,21,maison,moyenage,15,8,"door/");
        Door vJP = new Door(16,3,japon,prehistoire,4,4,"vortex/");
        Door vMaJ = new Door(34,11,moyenage,japon,16,21,"vortex/");
        Door vPM = new Door(0,20,prehistoire,moyenage,4,11,"vortex/");
        Door vPF = new Door(4,23,prehistoire,faille,8,11,"vortex/");

        TransporterDoor vR = new TransporterDoor(20,15,faille2,faille2,20,12,"vortex/");
        //Création des destination pour les TransporterDoor
        Coordinates[] pTab = {new Coordinates(prehistoire,4,4),new Coordinates(japon,16,21),new Coordinates(moyenage,4,11)}; 
        vR.setPossibleDestinations(pTab);

        //Ajout des objets et des doors dans les pieces
        vieu.placeOnGrid();
        katana.placeOnGrid();
        vMachine1.placeOnGrid();
        vMachiner.placeOnGrid();
        vFP.placeOnGrid();
        vFM.placeOnGrid();
        vFJ.placeOnGrid();
        vJT.placeOnGrid();
        vTJ.placeOnGrid();
        vPF2.placeOnGrid();
        vJF2.placeOnGrid();
        vMF2.placeOnGrid();
        vR.placeOnGrid();
        vMaM.placeOnGrid();
        vMMa.placeOnGrid();
        vMaJ.placeOnGrid();
        vPM.placeOnGrid();
        vJP.placeOnGrid();
        vPF.placeOnGrid();
        robert.placeOnGrid();
        philipe.placeOnGrid();
        samurai.placeOnGrid();
        kid.placeOnGrid();
        dino.placeOnGrid();
        tomate1.placeOnGrid();
        tomate2.placeOnGrid();
    }//CreateRooms
    /**
     * Interprète la commande en paramètre
     */
    public void processCommand(String pCom)
    {
        this.aGui.printc(pCom);
        Command vCom = aParser.getCommand(pCom);
        vCom.execute(aPlayer);

    }//processCommand()

    /**
     * Affiche le message de bienvenue
     */
    private void printWelcome()
    {
        aGui.println("         BIENVENUE DANS LE MONDE DE ZUUL " );
        aGui.println(" Vous êtes un scientifique, vous avez inventé une machine a voyager dans le temps."); 
        aGui.println(" ZQSD pour se déplacer, F pour ouvrir/fermer la boite de dialogue, E pour intéragir, I pour l'inventaire");
        printLocationInfo();
    }//printWelcome();

    /**
     * Affiche les informations sur la pièce actuelle
     */
    public void printLocationInfo()
    {
        aGui.showRoom(this.aPlayer.getRoom());
        aGui.println(this.aPlayer.getLocationInfo());

        //         aGui.showImage(this.aPlayer.getLocationPic());
    }

    /**
     * Affiche l'aide
     */
    public void printHelp()
    {
        aGui.println("Vous etes perdus" );
        aGui.println("Vous gardes votre calme et en profitez pour une petite promenade");
        aGui.println("Vous pouvez utiliser les commandes suivantes:");
        aGui.println(aParser.showCommands());
    }//printHelp();

    /**
     * affiche la string sur l'interface
     */
    public void println(String pString)
    {
        this.aGui.println(pString);
    }

    /**
     * renvoie la liste des rooms
     */
    public static ArrayList<Room> getRoomList()
    { 
        return aRoomList;
    }

    /**
     * effectue les actions quand un évenement avance
     */
    public void refreshTime()
    {
        //         if(!(aPlayer.getRoom().getNPCS().empty())){
        for(NonPlayerCharacters npc : aPlayer.getRoom().getNPCS().values())
        {npc.move();}
        //         }
    }

    /**
     * efface une entité affichée
     */
    public void eraseEntity(Entity pE)
    {
        aGui.eraseEntity(pE);
    }

    /**
     * affiche l'entité en paramètre
     */
    public void showEntity(Entity pE)
    {
        aGui.showEntity(pE);
    }

    /**
     * met a jour l'affichage d'une entité
     */
    public void refreshDisplay(Entity pE)
    {
        aGui.refreshEntity(pE);
    }

    /**
     * refresh le Gui
     */
    public void refresh()
    {
        aGui.refresh();
    }

    /**
     * Déplace le player dans la direction en paramètre, et le tourne s'il n'est pas tourné
     */
    public void movePlayer(Direction pDir)
    {
        if (!aPlayer.isFacing(pDir)) aPlayer.turn(pDir);
        aPlayer.move(pDir);
        aGui.refreshEntity(aPlayer);
    }

    //     public void moveRoom(Room pRoom)
    //     {
    //         //aPlayer.getRoom().remove(aPlayer);
    //         //aPlayer.setRoom(pRoom);
    //         //pRoom.add(aPlayer);
    // 
    //     }

    /**
     * retourne le player
     */
    public Player getPlayer()
    {return this.aPlayer;}

}
