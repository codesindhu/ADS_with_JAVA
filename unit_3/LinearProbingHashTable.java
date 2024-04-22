public class LinearProbingHashTable<K, V> {
    private int size;
    private int capacity;
    private K[] keys;
    private V[] values;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor with default capacity
    public LinearProbingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor with specified capacity
    public LinearProbingHashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    // Hash function to get index for a key
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Method to insert key-value pair into hash table
    public void put(K key, V value) {
        if (size >= capacity / 2) {
            resize(2 * capacity); // double the capacity if half full
        }
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            index = (index + 1) % capacity; // linear probing
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    // Method to get value for a given key
    public V get(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % capacity; // linear probing
        }
        return null;
    }

    // Method to remove key-value pair from hash table
    public void remove(K key) {
        if (!contains(key)) {
            return;
        }
        int index = hash(key);
        while (!keys[index].equals(key)) {
            index = (index + 1) % capacity; // linear probing
        }
        keys[index] = null;
        values[index] = null;
        size--;

        // Rehashing to maintain continuity
        index = (index + 1) % capacity;
        while (keys[index] != null) {
            K rehashKey = keys[index];
            V rehashValue = values[index];
            keys[index] = null;
            values[index] = null;
            size--;
            put(rehashKey, rehashValue);
            index = (index + 1) % capacity;
        }
    }

    // Method to check if the hash table contains a key
    public boolean contains(K key) {
        return get(key) != null;
    }

    // Method to check if the hash table is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the hash table
    public int size() {
        return size;
    }

    // Method to resize the hash table
    private void resize(int newCapacity) {
        LinearProbingHashTable<K, V> newHashTable = new LinearProbingHashTable<>(newCapacity);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newHashTable.put(keys[i], values[i]);
            }
        }
        this.keys = newHashTable.keys;
        this.values = newHashTable.values;
        this.capacity = newHashTable.capacity;
    }

    public static void main(String[] args) {
        LinearProbingHashTable<String, Integer> hashTable = new LinearProbingHashTable<>();

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

