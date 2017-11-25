import java.io.*;
import java.util.*;
/**
 * Write a description of class CreditCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreditCard
{

    public  String[][] cardValidity(String filePath){
        
        ArrayList<String> validNumbers = new ArrayList<>();
        ArrayList<String> notValidNumbers = new ArrayList<>();
        String line = " ";
        try{
            FileReader file = new FileReader(filePath);
        BufferedReader read = new BufferedReader(file);
            while((line=read.readLine())!=null){
                //System.out.println(line);
            if(isCreditCard(line)){
                validNumbers.add(line);
                
            }
            else 
            notValidNumbers.add(line);
        }
        
        }
        catch(IOException x){
            
        }
        String[] valid = validNumbers.toArray(new String[validNumbers.size()]);
        String[] notValid = notValidNumbers.toArray(new String[notValidNumbers.size()]);
        
        String[][] retCard = new String[2][];
        retCard[0]= valid;
        retCard[1]= notValid;
        return retCard;
        
    }
    public   boolean isCreditCard(String cardNumber){
        int sum=0;
        String lastNo = cardNumber.substring(cardNumber.length()-1);
        String dropped = cardNumber.substring(0,cardNumber.length()-1);
        StringBuilder rsr = new StringBuilder();
        rsr.append(dropped);
        rsr= rsr.reverse();
        String reversed = rsr.toString();
        int[] reversedInt = Arrays.stream(reversed.split("")).mapToInt(Integer::parseInt).toArray();
        //to change the string to integer array
        for(int i=0; i<reversedInt.length;i++){
            if(i%2==0){
                reversedInt[i]=reversedInt[i]*2;
                if(reversedInt[i]>9){
                    reversedInt[i]=reversedInt[i]-9;
                }
                
            }
            sum = sum + reversedInt[i];
            
        }
        sum = sum + Integer.parseInt(lastNo); // change to int 
        if(sum%10==0){
            return true;
        }
        else return false;
    }
    public void writeNonValid( String filePath)throws Exception{
        String[] nonValid = cardValidity(filePath)[1];
        PrintWriter writer = new PrintWriter( new File("C:/Users/owner/Desktop/nonValid.txt"));
        for( String x: nonValid){
            writer.write(x + "\n");
        }
        writer.close();
    }
}
