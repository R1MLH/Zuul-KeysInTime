package pkg_Core;
import pkg_GameElements.Item;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import javax.swing.*;
import java.awt.*;

/**
 * La liste des items dans une salle ou pour un joueur, ou autre?
 * 
 * @author Erwan MAILHARRO
 * @version 08/03/2016
 */
public class ItemList
{
    private HashMap<String,Item> aItemList;

    /**
     * Constructor for objects of class ItemList
     */
    public ItemList()
    {
        aItemList = new HashMap<String,Item>();
    }

    /**
     * renvoie l'item avec le nom pName
     */
    public Item getItem(String pName){return this.aItemList.get(pName);}

    /**
     * ajoute un item a la liste
     */
    public void addItem(Item pItem) {this.aItemList.put(pItem.getName(),pItem);}

    /**
     * enleve un item de la liste
     */
    public void removeItem(String pName) {this.aItemList.remove(pName);}

    /**
     * enleve un item de la liste
     */
    public void removeItem(Item pItem) {this.aItemList.remove(pItem.getName());}

    /**
     * permet de transférer un item vers une autre itemList
     */
    public void transferItemTo(ItemList pItemList,String pName)
    {
        // Item vTampon = this.aItemList.getItem(pName);
        if(!this.containsItem(pName)) return;
        else
        {
            pItemList.addItem(this.getItem(pName));
            this.removeItem(pName);
        }
    }

    /**
     * vérifie si l'item est contenu dans l'itemList
     */
    public boolean containsItem(String pString)
    {   boolean vBool = false;
        Set<String> keys = aItemList.keySet();
        for(String item : keys){
            if(item.equals(pString)) vBool = true;
        }
        return vBool;
    }

    /**
     * renvoie l'item list sous forme de string
     */
    public String getItemString()
    {
        String vReturnString = new String();
        Set<String> keys = aItemList.keySet();
        for(String item : keys){
            vReturnString += " " + item;
        }
        return vReturnString;
    }

    /**
     * renvoie le poids de l'itemList 
     */
    public int getWeight()
    {
        int vWeight = 0;
        Set<String> keys = aItemList.keySet();
        for(String item : keys){
            vWeight += this.getItem(item).getWeight();
        }
        return vWeight;
    }
    //public Item[] getItemList()

        
    public ArrayList<Item> getArray()
    {
        ArrayList<Item> vReturn = new ArrayList<Item>();
        Set<String> keys = aItemList.keySet();
        for(String item : keys){
           vReturn.add(aItemList.get(item));
        } 
        return vReturn;
    }
}

