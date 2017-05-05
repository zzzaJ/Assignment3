/**
* HashFunctions class which holds the source code for four hash functions.
* The HashFunctions class contains the source code for 4 hash functions.
* Creation of a default hash function object allows for the utilization of the functions
*
* @author  Dino Bossi
* @version 1.0
* @since   2017-01-05
*/
public class HashFunctions {
    
    /**
     * static table-size value
     */
    public static int TABLESIZE = 20011;
    
   /**
   * Method used to change the table-size variable.
   * The integer arguement n is used to reassign a value to table-size
   */
    public void chooseN(int n){
        
        TABLESIZE = n;

    }
    
   /**
   * Hash Method 1.
   * This is the worst case hash function, returning the same value for all string arguements.
   * 
   * @return integer hash value
   */
    public int hash1 ( String key ){
        
        return 1;
        
    }
    /**
   * Hash Method 2.
   * A more complex hash function using unicode values, returning a specific hash value for all string arguements.
   * 
   * @return integer hash value
   */
    public int hash2 ( String key ){
        int hashVal = 0;
        for( int i = 0; i < key.length(); i++ ){
            
        
            hashVal += key.charAt(i);

        }        
        return hashVal % TABLESIZE;
    }
    
   /**
   * Hash Method 3.
   * A complex hash function which uses prime multiplication to spread hash values more evenly.Returns a specific integer value
   * for all string arguements.
   * 
   * @return integer hash value
   */
    public int hash3 ( String key ){
        int hashVal = 0;
        for( int i = 0; i < key.length(); i++ ){
            
            hashVal = (37 * hashVal) + key.charAt(i);
            
        }
        return Math.abs(hashVal % TABLESIZE);
    }
    
   /**
   * Hash Method 3.
   * An extremely complex hash function which uses prime multiplication to spread hash values more evenly. It 
   * also utilizes splitting of strings into 4 character substrings to increase hash value spread. Returns a specific integer value
   * for all string arguements.
   * 
   * @return integer hash value
   */
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
    
}


