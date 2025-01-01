package hashing;


    import java.util.LinkedList;

class HashTable {

    private int capacity;
    private LinkedList<Entry>[] table;

    class Entry {

        String key;
        String value;
        
        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, String value) { 

        int hash = getHash(key);
        for (Entry entry : table[hash]) {

            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[hash].add(new Entry(key, value));
    }

    public String get(String key) {

        int hash = getHash(key);
        for (Entry entry : table[hash]) {

            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
}


