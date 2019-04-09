package pkg_GameElements;
/**
 * Les objets utilisable
 * Cette classe n'a pas pour but d'être instanciée, mais sert de classe mère a toutes les classes d'objets utilisables.
 * 
 * @author Erwan Mailharro
 * @version 10/04/16
 */
public abstract class UseableItem extends Item
{

    /**
     * Constructeur de la classe abstraite useable item
     * @param pName le nom
     * @param pDescription la description
     * @param pWeight le poids
     */
    public UseableItem(String pName,String pDescription,final int pWeight,String pImage)
    {
        super(pName,pDescription,pWeight,pImage);
    }
    
    public UseableItem()
    {
        super();
    }
} // UseableItem

