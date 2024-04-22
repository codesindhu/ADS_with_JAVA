
package hashmap4;

import java.util.HashMap;

public class HashMap4 
{

    public static void main(String[] args) 
    {
        // Create an Integer HashMap.
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(1, 1000);
        h.put(20, 1001);
        h.put(300, 1003);

        // Use containsKey.
        if (h.containsKey(1)) {
            System.out.println("1 was found");
        }
        if (h.containsKey(300)) {
            System.out.println("300 was found");
        }
        if (!h.containsKey(400)) {
            System.out.println("400 was not found");
        }
    }
    
}
//1 was found
//300 was found
//400 was not found
