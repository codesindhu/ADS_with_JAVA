
package hashmap1;

import java.util.HashMap;

public class HashMap1 
{

    public static void main(String[] args) 
    {
       // Step 1: create new HashMap.
        HashMap<String, Integer> hash = new HashMap<>();

        // Step 2: put 3 keys with values.
        hash.put("dog", 1);
        hash.put("cat", 2);
        hash.put("bird", 3);

        // Step 3: lookup a known value.
        int result = hash.get("cat");

        // Step 4: display result.
        System.out.println("RESULT: " + result);
    }
    
}
//2
