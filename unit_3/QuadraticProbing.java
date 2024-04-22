import java.util.Arrays;

class HashTable {
    private int[] data;
    private static final int C1 = 1; // Quadratic probing constant 1
    private static final int C2 = 1; // Quadratic probing constant 2

    public HashTable(int size) {
        data = new int[size];
Arrays.fill(data, -1); // Initialize all slots as empty (-1 indicates an empty slot)
    }

    private int hash(int key) {
        return key % data.length;
    }

    public void put(int key) {
        int hashKey = hash(key);
        int index = hashKey;
        int i = 1; // Number of probing attempts

        // Quadratic probing until an empty slot is found or table is full
        while (data[index] != -1) {
            index = (hashKey + C1 * i + C2 * i * i) % data.length; // Quadratic probing formula
            if (i == data.length) {
System.out.println("Hash table is full. Unable to insert key: " + key);
                return; // Hash table is full
            }
i++;
        }

        // Insert the key into the empty slot
        data[index] = key;
    }

    public void display() {
        for (int i = 0; i<data.length; i++) {
System.out.println("Index " + i + ": " + data[i]);
        }
    }
}

public class QuadraticProbing {
    public static void main(String[] args) {
HashTable ht = new HashTable(10);
ht.put(5);
ht.put(15);
ht.put(25);
ht.put(35);
ht.put(45);
ht.put(55);
ht.put(65);
ht.put(75);
ht.put(85);
ht.put(95);
ht.put(105); // Hash table is full, unable to insert

ht.display();
    }
}	
