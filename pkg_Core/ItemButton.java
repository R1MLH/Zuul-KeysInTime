package pkg_Core;
import pkg_GameElements.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Bouton pour l'inventaire, correspond a un Item.
 * 
 * @author Erwan MAILHARRO
 * @version 29-05-16
 */
public class ItemButton extends JRadioButton
{
    Item aItem;

    /**
     * Constructor for objects of class ItemButton
     */
    public ItemButton(String pDesc,Item pItem)
    {
        super(pDesc);
        aItem = pItem;
    }

    
    public Item getItem()
    {
        return this.aItem;
    }
}
