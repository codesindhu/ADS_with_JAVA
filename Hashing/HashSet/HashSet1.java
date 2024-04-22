
package hashset1;

import java.util.HashSet;

public class HashSet1 
{

    public static void main(String[] args)
    {
         // Create HashSet.
        HashSet<String> hash = new HashSet<>();
        hash.add("castle");
        hash.add("bridge");
        hash.add("castle"); // Duplicate element.
        hash.add("moat");

        // Display size.
        System.out.println(hash.size());

        // See if these three elements exist.
        System.out.println(hash.contains("castle"));
        System.out.println(hash.contains("bridge"));
        System.out.println(hash.contains("moat"));
    }
    
}
