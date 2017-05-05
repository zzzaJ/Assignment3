
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dino
 */
public class HashFunctions {
    
    /**
     * 
     */
    public static int TABLESIZE = 20011;
    
    
    public void choseN(int n){
        
        TABLESIZE = n;
        
        
    }
    
    public int hash1 ( String key ){
        
        return 1;
        
    }
 
    public int hash2 ( String key ){
        int hashVal = 0;
        for( int i = 0; i < key.length(); i++ ){
            
        
            hashVal += key.charAt(i);

        }        
        return hashVal % TABLESIZE;
    }
    
    public int hash3 ( String key ){
        int hashVal = 0;
        for( int i = 0; i < key.length(); i++ ){
            
            hashVal = (37 * hashVal) + key.charAt(i);
            
        }
        return Math.abs(hashVal % TABLESIZE);
    }
    
    public int hash4 ( String key) {
        
        int intLength = key.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
         
            char c[] = key.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            
            for (int k = 0; k < c.length; k++) {
            
                sum += c[k] * mult;
                mult *= 256;
         
            }
        }

        char c[] = key.substring(intLength * 4).toCharArray();
        long mult = 1;
        
        for (int k = 0; k < c.length; k++) {
         
            sum += c[k] * mult;
            mult *= 256;
       
        }

        return(int) (Math.abs(sum) % TABLESIZE);
     
   }
        
    
//    public static void main(String [] args){
//
//    HashFunctions hf = new HashFunctions();
//    hf.calculateEntropy();
//
//}
    
}


