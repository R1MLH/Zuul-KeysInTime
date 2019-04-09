package pkg_GameElements;
/**
 * Les objets comestibles (food) permettent d'augmenter le carry du player lorsqu'ils sont mangés.
 * 
 * @author Erwan Mailharro
 * @version 10/04/16
 */
public class Food extends UseableItem
{
    int aBonus;
    
    /**
     * default constructor for objects of class Food
     */
    public Food()
    {
        super();
        aBonus = 50;
    }
    
    public Food(String pName,String pDescription,final int pWeight,String pI)
    {
       this(pName,pDescription,pWeight,50,pI);
    } 
    
    public Food(String pName,String pDescription,final int pWeight,final int pBonus,String pI)
    {
         super(pName,pDescription,pWeight,pI);
        aBonus = pBonus;
        
    }
    
    /**
     * renvoie le bonus au carry d'un aliment.
     */
    public int getBonus(){return this.aBonus;}
} // Food

