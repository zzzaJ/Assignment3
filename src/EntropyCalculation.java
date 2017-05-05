
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* EntropyCalculation class which handles the running of the entropy calculation.
* The entropy calculation class deals with the running of code to determine the entropy for 
* four various hash functions, of varying complexity and efficiency.
*
* @author  Dino Bossi
* @version 1.0
* @since   2017-01-05
*/
public class EntropyCalculation {
    
   
    
    /**
   * This method is used to load in the testdata and conduct calculations to determine entropy.
   * The method reads the data from testdata and calculates a hash value for all provided keys (full names)
   */
    public void calculateEntropy(){  
        
        String [] keys = new String[10000]; //initialize string array to hold full names
        
        HashFunctions hf = new HashFunctions(); //initialize hash function object to allow hashing of keys
        
        List<Integer> hashVals1 = new ArrayList(); //initialise list to hold hashvalues from hash1 method
        List<Integer> hashVals2 = new ArrayList(); //initialise list to hold hashvalues from hash2 method
        List<Integer> hashVals3 = new ArrayList(); //initialise list to hold hashvalues from hash3 method
        List<Integer> hashVals4 = new ArrayList(); //initialise list to hold hashvalues from hash4 method
        
        //initilising hash tables that allow the determining of hash value occurences (i.e. how many times a specific hash value is calculated)
        
        int [] hashtbl1 = new int[20011]; // Initialising hash table to hold hash1 hashed values
        int [] hashtbl2 = new int[20011]; // Initialising hash table to hold hash2 hashed values
        int [] hashtbl3 = new int[20011]; // Initialising hash table to hold hash3 hashed values
        int [] hashtbl4 = new int[20011]; // Initialising hash table to hold hash4 hashed values
        
        String line; //String variable to hold scanf lines
        
        try { //try and catch used to catch any errors encountered when reading in testdata
            
            Scanner scanf = new Scanner(new File("testdata")); //initialising scanner object to allow reading of testdata
            for(int i = 0; i < 10000; i++){ // adding each full name from testdata to keys array 
                
                line = scanf.nextLine();
                keys[i] = line.substring(line.lastIndexOf("|")+1);
                
            }
            
            scanf.close(); //close scanner object 
            
        } catch (FileNotFoundException ex) { //subsequent catch to catch filenotfound errors
            
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
 
       
        double sum1 = 0;//initialising sum values to be used to calculate entropy
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        

        
        for(int i = 0; i < 20011; i++){ //incrementing sum values to determine entropy for each hash function
            
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
        
        System.out.println("1: " + sum1); // printing the entropy values for each hash function
        System.out.println("2: " + sum2);
        System.out.println("3: " + sum3);
        System.out.println("4: " + sum4);
          
    }
    
    
   /**
   * Main method used to call entropy calculation method.
   * The main method allows for the execution of the calculate entropy method
   */
    public static void main(String [] args){
        
        EntropyCalculation ec = new EntropyCalculation();
        ec.calculateEntropy();
        
    }
    
}
