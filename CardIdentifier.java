import java.util.*;
import java.util.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class BankIdentifier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardIdentifier
{
   public HashMap<String,String> cardType(String[] validNumber){
       
       HashMap<String,String> map = new HashMap<>();
       for(String x : validNumber){
           if((x.startsWith("34")|| x.startsWith("37"))&& x.length()==15){
               map.put(x, "American Express");
               
            }
            if((x.startsWith("637") || x.startsWith("638") || x.startsWith("639"))&& x.length()==16){
               map.put(x, "Insta Payment");
               
            }
        }
        return map;
    }
    public void writeValid( HashMap<String,String> mapped)throws Exception{
        //String[] Valid = cardValidity(filePath)[0];
        PrintWriter writer = new PrintWriter( new File("C:/Users/owner/Desktop/Valid.txt"));
        for( String x: mapped.keySet()){
            writer.write(x +" "+ mapped.get(x)+ "\n");// gets the valid number with the respective bank
        }
        writer.close();
    }
}
