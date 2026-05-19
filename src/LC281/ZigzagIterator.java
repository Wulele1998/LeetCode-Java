package LC281;

import java.util.List;

public class ZigzagIterator {
    private int index1;
    private int index2;
    private List<Integer> v1;
    private List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index1 = 0;
        index2 = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (index1 == v1.size()) {
            return v2.get(index2++);
        }
        if (index2 == v2.size())
            return v1.get(index1++);

        return index1 > index2 ? v2.get(index2++) : v1.get(index1++);
    }

    public boolean hasNext() {
        return !(index1 == v1.size() && index2 == v2.size());
    }
}
