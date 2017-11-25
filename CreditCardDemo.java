import java.util.*;
/**
 * Write a description of class CreditCardDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreditCardDemo
{
    public static void main(String[] args)throws Exception{
        CreditCard card = new CreditCard();
        String[] valid = card.cardValidity("C:/Users/owner/Desktop/DataEvaluate.txt")[0];
        CardIdentifier id = new CardIdentifier();
        System.out.println(id.cardType(valid));
        String[][] ret =card.cardValidity("C:/Users/owner/Desktop/DataEvaluate.txt");
        for(String [] x : ret){
            System.out.println(Arrays.toString(x));
        }
        card.writeNonValid("C:/Users/owner/Desktop/DataEvaluate.txt");
        id.writeValid(id.cardType(valid));
    }
    
}
