package LC380;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int index = map.get(val);
        int lastVal =  list.get(list.size() - 1);
        // swap the value with the last element at the list
        list.set(index, lastVal);
        // update the map
        map.put(lastVal, index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        // nextInt not include the bound
        return list.get(random.nextInt(list.size()));
    }
}

/*
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
