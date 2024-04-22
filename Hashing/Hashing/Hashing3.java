
package hashing3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashing3 {

    public static void main(String[] args) 
    {
        Map<String, String> map = new HashMap<>();
        String[] keysarray = new String[5];
        map.put("10000-A", "Ram");
        map.put("20000-B", "Lakshman");
        map.put("30000-C", "Sita");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int hash = 0;
            for(var ch:key.toCharArray())
            {
                hash+=ch;
            }
            int index = hash%5;
            keysarray[index] = key;
            System.out.println(index+" "+keysarray[index]);
        }
    }
    
}
