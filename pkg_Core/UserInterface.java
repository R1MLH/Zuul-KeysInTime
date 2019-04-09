package pkg_Core;
import pkg_GameElements.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

/**
 *Cette classe représente l'interface graphique:
 *cela inclut : le background, avec l'image de la piece
 *les entitées , qui correspondent aux éléments du jeu qui vont intéragir
 *la chatBox, qui affiche les dialogues et les informations du jeu
 *la commandBox, qui affiche les commandes et permet d'en taper
 *l'inventaire, qui affiche les objets de l'inventaire et permet des les utiliser ou de les drop
 * 
 * @author Erwan Mailharro
 * @version 05-06-016
 */
public class UserInterface implements ActionListener
{

    private GameEngine engine; // le moteur du jeu
    private JFrame frame; // la fenetre
    private JLabel background; // l'arriere plan

    private HashMap<Entity,JLabel> aDisplayed; // les entitées affichées (Characters, Item, Door, Terrain...)
    private JTextArea chatBox; // la boite de dialogue
    private JScrollPane listScroller; // la boite de dialogue

    private JTextArea commandHist; // les commandes executées
    private JScrollPane commandScroller;
    private JTextField entryField; // le champ pour entrer les commandes
    private JPanel commandPanel;

    private JPanel inventory; // l'inventaire
    private JPanel bPanel;
    private ButtonGroup bG;

    public UserInterface(GameEngine gameEngine)
    {
        engine = gameEngine;
        createGUI();
        aDisplayed = new HashMap<Entity,JLabel>();

    }

    public void createGUI()
    {
        frame = new JFrame("ProtoZuul");

        background = new JLabel();
        background.setPreferredSize(new Dimension(1286,792));
        background.setLayout(null);

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        listScroller = new JScrollPane(chatBox);
        listScroller.setSize(0,0);

        inventory = new JPanel();
        inventory.setSize(0,0);
        JButton useButton = new JButton("use");
        useButton.setAction(use);
        JButton dropButton = new JButton("drop");
        dropButton.setAction(drop);
        JPanel invControl = new JPanel();
        invControl.setLayout(new GridLayout(2,2));
        invControl.add(useButton);
        invControl.add(dropButton);
        inventory.setLayout(new BorderLayout());
        inventory.add(invControl,BorderLayout.EAST);
        background.add(listScroller);
        background.add(inventory);
        listScroller.setLocation(150,500);
        inventory.setLocation(850,100);
        useButton.setSize(100,100);

        commandHist = new JTextArea();
        commandHist.setEditable(false);
        commandScroller = new JScrollPane(commandHist);
        entryField = new JTextField(34);
        commandPanel = new JPanel();
        commandPanel.setLayout(new BorderLayout());
        commandPanel.add(entryField, BorderLayout.SOUTH);
        commandPanel.add(commandScroller,BorderLayout.CENTER);
        background.add(commandPanel);
        commandPanel.setSize(96,96);
        commandPanel.setLocation(1,1);
        entryField.addActionListener(this);
        refresh();

        background.getInputMap().put(KeyStroke.getKeyStroke("Z"),"z");
        background.getActionMap().put("z", goUp);

        background.getInputMap().put(KeyStroke.getKeyStroke("Q"),"q");
        background.getActionMap().put("q",goLeft);

        background.getInputMap().put(KeyStroke.getKeyStroke("S"),"s");
        background.getActionMap().put("s",goDown);
        background.getInputMap().put(KeyStroke.getKeyStroke("D"),"d");
        background.getActionMap().put("d",goRight);
        background.getInputMap().put(KeyStroke.getKeyStroke("F"),"fo");
        background.getActionMap().put("fo",openChat);
        background.getInputMap().put(KeyStroke.getKeyStroke("E"),"interact");
        background.getActionMap().put("interact",interact);
        background.getInputMap().put(KeyStroke.getKeyStroke("T"),"t");
        background.getActionMap().put("t",test);

        background.getInputMap().put(KeyStroke.getKeyStroke("C"),"c");
        background.getActionMap().put("c",back);
        background.getInputMap().put(KeyStroke.getKeyStroke("I"),"i");
        background.getActionMap().put("i",openInventory);

        background.requestFocus();

        chatBox.getInputMap().put(KeyStroke.getKeyStroke("F"),"fc");
        chatBox.getActionMap().put("fc",closeChat);
        chatBox.getInputMap().put(KeyStroke.getKeyStroke("E"),"ec");
        chatBox.getActionMap().put("ec",interact);

        inventory.getInputMap().put(KeyStroke.getKeyStroke("I"),"ii");
        inventory.getActionMap().put("ii",closeInventory);
        frame.setResizable(false);
        closeChat();

    }

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(ActionEvent e) 
    {

        if (e.getSource() == entryField)
        {
            String input = entryField.getText();
            entryField.setText("");
            background.requestFocus();
            engine.processCommand(input);  

        }

    }

    Action use = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                    engine.processCommand("use " + bG.getSelection().getActionCommand());
                }
                catch(NullPointerException exc)
                {
                }
                inventory.requestFocus();

                closeInventory();
                openInventory();
            }

        };

    Action drop = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                    engine.processCommand("drop " + bG.getSelection().getActionCommand());
                }
                catch(NullPointerException exc)
                {
                }
                inventory.requestFocus();

                closeInventory();
                openInventory();
            }

        };
    Action goUp = new AbstractAction() 
        {
            public void actionPerformed(ActionEvent e)
            {
                engine.processCommand("go up");
            }
        };

    Action goDown = new AbstractAction() 
        { 
            public void actionPerformed(ActionEvent e)
            {
                engine.processCommand("go down");
            }
        };

    Action goLeft = new AbstractAction() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                engine.processCommand("go left");
            }
        };

    Action goRight = new AbstractAction() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                engine.processCommand("go right");
            }
        };

    Action closeChat = new AbstractAction() 
        {
            public void actionPerformed(ActionEvent e)
            {
                closeChat();
            }
        };

    Action openChat = new AbstractAction() 
        {
            public void actionPerformed(ActionEvent e)
            {
                openChat();
            }
        };

    Action interact = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {

                engine.getPlayer().interact(engine.getPlayer());

            }
        };

    Action test = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                engine.processCommand("test test.txt");
            }
        };

    Action openInventory = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                openInventory();
            }

        };

    Action closeInventory = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                closeInventory();
            }
        };

    Action back = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                engine.processCommand("back");
            }
        };

    /**
     * affiche l'entité en paramètre 
     */
    public void showEntity(Entity pE)
    {
        URL imageURL = this.getClass()/*.getClassLoader()*/.getResource(pE.getImage());
        JLabel vE = new JLabel();
        if(imageURL == null) ;
        // System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);

            vE.setIcon(icon);

        }
        aDisplayed.put(pE,vE);
        vE.setSize(32,32);
        background.add(vE);
        //vE.setBounds(new Rectangle(new Point(pE.getCoordinate("x"),pE.getCoordinate("y")), vE.getPreferedSize()));
        vE.setLocation(pE.getVCoordinate("x"),pE.getVCoordinate("y"));
        refresh();

    }

    /**
     * ferme la chatBox
     */
    public void closeChat()
    {
        listScroller.setSize(0,0);
        refresh();
    }

    /**
     * ferme l'inventaire
     */
    public void closeInventory()
    {
        inventory.remove(bPanel);
        inventory.setSize(0,0);
        refresh();
    }

    /**
     * ouvre l'inventaire
     */
    public void openInventory()
    {
        makeInvPanel();
        inventory.add(bPanel);
        inventory.setSize(300,400);
        refresh();
        inventory.requestFocus();
    }

    /**
     * génère l'inventaire
     */
    public void makeInvPanel()
    {
        bG = new ButtonGroup();
        bPanel = new JPanel();
        bPanel.setLayout(new GridLayout(0,1));
        ItemButton rb;
        ArrayList<Item> inv = engine.getPlayer().getItemList().getArray(); 
        for(Item it : inv)
        {
            rb = new ItemButton(it.getName(),it);
            rb.setActionCommand(it.getName());
            bPanel.add(rb);
            bG.add(rb);
        }
    }

    /**
     * ouvre le chat
     */
    public void openChat()
    {
        listScroller.setSize(1000,200);
        refresh();
        chatBox.requestFocus();
    }

    /**
     * affiche la room
     */
    public void showRoom(Room pRoom)
    {

        Set<Entity> keys = aDisplayed.keySet();
        for(Entity e : keys) {

            aDisplayed.get(e).setSize(0,0);
            background.remove(aDisplayed.get(e));

        }

        aDisplayed.clear();
        URL imageURL = this.getClass()./*getClassLoader().*/getResource(pRoom.getImage());
        if(imageURL == null);
        //System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            background.setIcon(icon);

        }
        HashMap<Coordinates,Entity> vMap= pRoom.getEntities();
        Set<Coordinates> key = vMap.keySet();
        for(Coordinates z : key){
            showEntity(vMap.get(z));

        }

    }

    /**
     * met a jour l'affichage d'une entité
     */
    public void refreshEntity(Entity pE)
    {
        URL imageURL = this.getClass()./*getClassLoader().*/getResource(pE.getImage());
        if(imageURL == null);
        //System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            aDisplayed.get(pE).setIcon(icon);

        }

        aDisplayed.get(pE).setLocation(pE.getVCoordinate("x"),pE.getVCoordinate("y"));

        refresh();
    }

    /**
     * efface une entité
     */
    public void eraseEntity(Entity pE)
    {
        background.remove(aDisplayed.get(pE));
        aDisplayed.remove(pE);
    }

    /**
     * affiche un texte dans la chatbox=avec un retour a la ligne
     */
    public void println(String text)
    {
        print(text + "\n");
    }

    /**
     * affiche un texte dans la chatbox
     */
    public void print(String text)
    {
        openChat();
        chatBox.append(text);
        chatBox.setCaretPosition(chatBox.getDocument().getLength());
    }

    /**
     * affiche un texte dans la commandBox
     */
    public void printc(String text)
    {
        commandHist.append(text + "\n");
        commandHist.setCaretPosition(commandHist.getDocument().getLength());
    }

    /**
     * refresh le gui
     */
    public void refresh()
    {
        frame.setContentPane(background);
        frame.pack();
        frame.setVisible(true);
        background.requestFocus();
        //         chatBox.requestFocus();
    }

}
