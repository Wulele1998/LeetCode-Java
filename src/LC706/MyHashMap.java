package LC706;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<>();
    }

    public int get(int key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        boolean isExist = false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.key == key) {
                pair.value = value;
                isExist = true;
            }
        }

        if (!isExist)
            this.bucket.add(new Pair<Integer, Integer>(key, value));
    }

    public void remove(int key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.key == key) {
                this.bucket.remove(pair);
                return;
            }
        }
    }
}

public class MyHashMap {
    private final int KEY_SPACE = 2069;
    private List<Bucket> hashTable;

    public MyHashMap() {
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < this.KEY_SPACE; i++) {
            hashTable.add(new Bucket());
        }    
    }

    public void put(int key, int value) {
        int hashKey = key % this.KEY_SPACE;
        this.hashTable.get(hashKey).put(key, value);
    }

    public int get(int key) {
        int hashKey = key % this.KEY_SPACE;
        return this.hashTable.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % this.KEY_SPACE;
        this.hashTable.get(hashKey).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */

