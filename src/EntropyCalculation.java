
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntropyCalculation {
    
    
    
    public void calculateEntropy(){  
        
        String [] keys = new String[10000];
        
        HashFunctions hf = new HashFunctions();
        
        List<Integer> hashVals1 = new ArrayList();
        List<Integer> hashVals2 = new ArrayList();
        List<Integer> hashVals3 = new ArrayList();
        List<Integer> hashVals4 = new ArrayList();
        
        int [] hashtbl1 = new int[20011];
        int [] hashtbl2 = new int[20011];
        int [] hashtbl3 = new int[20011];
        int [] hashtbl4 = new int[20011];
        
        String line;
        
        try {
            
            Scanner scanf = new Scanner(new File("testdata"));
            for(int i = 0; i < 10000; i++){
                
                line = scanf.nextLine();
                keys[i] = line.substring(line.lastIndexOf("|")+1);
                
            }
            
            scanf.close();
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(HashFunctions.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        

        for(int i = 0; i < keys.length; i++){ //hashing the keys values and adding them to subsequent lists
            
           hashVals1.add(hf.hash1(keys[i])); 
           hashVals2.add(hf.hash2(keys[i])); 
           hashVals3.add(hf.hash3(keys[i]));            
           hashVals4.add(hf.hash4(keys[i])); 
           
        }
        
        for(int i = 0; i < 10000; i++){ //adding elements from hash value lists to hash tables
            
            hashtbl1[hashVals1.get(i)] = hashtbl1[hashVals1.get(i)] + 1;
            hashtbl2[hashVals2.get(i)] = hashtbl2[hashVals2.get(i)] + 1;
            hashtbl3[hashVals3.get(i)] = hashtbl3[hashVals3.get(i)] + 1;
            hashtbl4[hashVals4.get(i)] = hashtbl4[hashVals4.get(i)] + 1;
            
        }
 
       
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        

        
        for(int i = 0; i < 20011; i++){
            
            if(hashtbl1[i]!=0){
                sum1 += (((double)hashtbl1[i])/10000) * Math.log((((double)hashtbl1[i])/10000)) * -1;
            }
            
            if(hashtbl2[i]!=0){
                sum2 += (((double)hashtbl2[i])/10000) * Math.log((((double)hashtbl2[i])/10000)) * -1;
            }
            
            if(hashtbl3[i]!=0){
                sum3 += (((double)hashtbl3[i])/10000) * Math.log((((double)hashtbl3[i])/10000)) * -1;
            }
            
            if(hashtbl4[i]!=0){
                sum4 += (((double)hashtbl4[i])/10000) * Math.log((((double)hashtbl4[i])/10000)) * -1;
            }     
            
            
        }
        
        System.out.println("1: " + sum1);
        System.out.println("2: " + sum2);
        System.out.println("3: " + sum3);
        System.out.println("4: " + sum4);
          
    }
    
    public static void main(String [] args){
        
        EntropyCalculation ec = new EntropyCalculation();
        ec.calculateEntropy();
        
    }
    
}
