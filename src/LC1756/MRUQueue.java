package LC1756;

import java.util.ArrayList;
import java.util.List;

public class MRUQueue {
    // use arraylist
    List<Integer> list;
    public MRUQueue(int n) {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public int fetch(int k) {
        int element = list.get(k - 1);
        list.remove(k - 1);
        list.add(element);

        return element;
    }
}
