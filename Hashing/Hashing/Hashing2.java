package hashing2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashing2 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        int[] keysarray = new int[5];
        map.put(10000, "Ram");
        map.put(20000, "Lakshman");
        map.put(30000, "Sita");
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            int index = key % 5;
            keysarray[index] = key;
            System.out.println(keysarray[index]);
        }

    }

}
