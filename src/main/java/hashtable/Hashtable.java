package hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashtable<T> {

    private final ArrayList keys = new ArrayList();

    private final ArrayList<LinkedList<T>> values = new ArrayList<>();

    private int hashFunction(String stringToHash) {
        int hashKey = 0;
        for (int i = 0; i < stringToHash.length(); i++) {
            hashKey += (int)stringToHash.charAt(i);
        }
        return hashKey;
    }

    public void add(T key, T value) {
        //TODO detect and throw exception when caller attempts to add the exact same key twice
        if (key == null) {
            throw new IllegalArgumentException("Error: key can't be null");
        }
        int hashKey = hashFunction(key.toString());
        if (!keys.contains((hashKey))) {
            keys.add(hashKey);
            int index = keys.indexOf(hashKey);
            LinkedList bucket = new LinkedList();
            bucket.add(key);
            bucket.add(value);
            values.add(index, bucket);
        }
        else {
            int index = keys.indexOf(hashKey);
            LinkedList bucket = values.get(index);
            bucket.add(key);
            bucket.add(value);
        }
    }

    public T find(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Error: key can't be null");
        }
        if (keys.size() == 0 || !keys.contains(hashFunction(key.toString()))) {
            return null;
        }
        int index = keys.indexOf(hashFunction(key.toString()));
        LinkedList<T> bucket = values.get(index);
        if (bucket.contains(key)) {
            int valueIndex = bucket.indexOf(key) + 1;
            return bucket.get(valueIndex);
        }
        return null;
    }

    public boolean contains(T key) {
        return false;
    }

    private boolean contains(int hashKey) {
        if (keys.contains(hashKey)) {
            return true;
        }
        return false;
    }

    public int getHash(T key) {

        return -1;
    }

    protected ArrayList getKeys() {
        return keys;
    }

    protected ArrayList<LinkedList<T>> getValues() {
        return values;
    }
}
