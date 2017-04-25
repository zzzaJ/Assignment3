
import java.math.BigInteger;

public class testing {
    
    
            
      public static int hash3 ( String key ){ issue being caused by overflow of the number 
        BigInteger hashVal = new BigInteger("0");
        for( int i = 0; i < key.length(); i++ ){
            System.out.println("b: " + i + "  " + hashVal);
            hashVal = (37 * hashVal) + key.charAt(i);
            System.out.println("a: " + i + "  " + hashVal);
        }
        return (int) (hashVal % 20011);
    }  
      
      public static void main(String [] args){
          
          System.out.println(hash3("Wilkinson Montana"));
          
      }
    
    
}
