package hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A hashtable implementation.
 * @param <T> The data type that instances will use for values.
 */
public class Hashtable<T> {

    /**
     * The hashtable keys.
     */
    private final ArrayList keys = new ArrayList();

    /**
     * The hashtable values.
     */
    private final ArrayList<LinkedList<T>> values = new ArrayList<>();

    /**
     * Simple ASCII sum based hash funtion.
     * @param stringToHash Input String to hash.
     * @return The hashed value.
     */
    private int hashFunction(String stringToHash) {
        int hashKey = 0;
        for (int i = 0; i < stringToHash.length(); i++) {
            hashKey += (int)stringToHash.charAt(i);
        }
        return hashKey;
    }

    /**
     * Adds value for passed in key to this hashtable.
     * @param key The key.
     * @param value The value.
     */
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

    /**
     *
     * @param key
     * @return
     */
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

    /**
     *
     * @param key
     * @return
     */
    public boolean contains(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Error: key can't be null");
        }
        if (keys.contains(hashFunction(key.toString()))) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    public int getHash(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Error: key can't be null");
        }
        if (keys.contains(hashFunction(key.toString()))) {
            return keys.indexOf(hashFunction(key.toString()));
        }
        return -1;
    }

    /**
     *
     * @return
     */
    protected ArrayList getKeys() {
        return keys;
    }

    /**
     *
     * @return
     */
    protected ArrayList<LinkedList<T>> getValues() {
        return values;
    }
}
