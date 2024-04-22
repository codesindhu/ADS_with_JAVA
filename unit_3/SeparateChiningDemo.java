import java.util.LinkedList;

class SeparateChainingHashTable<K, V> {
    private int size;
    private LinkedList<Entry<K, V>>[] table;
    private static final int DEFAULT_CAPACITY = 10;

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor with default capacity
    public SeparateChainingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor with specified capacity
    public SeparateChainingHashTable(int capacity) {
        this.size = 0;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to get index for a key
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    // Method to insert key-value pair into hash table
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    // Method to get value for a given key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // Method to remove key-value pair from hash table
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    // Method to check if the hash table is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the hash table
    public int size() {
        return size;
    }
}

public class SeparateChiningDemo
 {
    public static void main(String[] args) {
        SeparateChainingHashTable<String, Integer> hashTable = new SeparateChainingHashTable<>();

        // Inserting key-value pairs
        hashTable.put("John", 25);
        hashTable.put("Emily", 30);
        hashTable.put("Tom", 35);

        // Retrieving values
        System.out.println("John's age: " + hashTable.get("John"));
        System.out.println("Emily's age: " + hashTable.get("Emily"));
        System.out.println("Tom's age: " + hashTable.get("Tom"));

        // Removing a key-value pair
        hashTable.remove("Emily");

        // Checking if the hash table is empty
        System.out.println("Is the hash table empty? " + hashTable.isEmpty());

        // Getting the size of the hash table
        System.out.println("Size of the hash table: " + hashTable.size());
    }
}

