
package hashmap3;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMap3 
{

    public static void main(String[] args)
    {
         // Create HashMap and put 3 entries in it.
        HashMap<String, Integer> values = new HashMap<>();
        values.put("Java", 6);
        values.put("Python", 4);
        values.put("C#", 5);

        // Loop over HashMap with entrySet.
        // ... The ordering is not maintained.
        for (Entry<String, Integer> pair : values.entrySet()) {
            System.out.println(pair.getKey() + "::" + pair.getValue());
        }
    }
    
}
//C#::5
//Java::6
//Python::4