
package hashtable;

import java.util.Hashtable;

public class HashTable 
{

    public static void main(String[] args) 
    {
        // Create Hashtable and add two entries.
        Hashtable<String, Integer> hash = new Hashtable<>();
        hash.put("cat", 10);
        hash.put("dog", 15);

        // Get value at this key.
        int value = hash.get("cat");
        System.out.println(value);
    }
    
}
