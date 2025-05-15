package OA;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

class Package {
    String id;
    int size;

    public Package(String id, int size) {
        this.id = id;
        this.size = size;
    }
}

class Locker {
    String id;
    int size;

    public Locker(String id, int size) {
        this.id = id;
        this.size = size;
    }
}

public class Practice1 {
    List<Package> packages;
    List<Locker> lockers;
    HashMap<Integer, Queue<Locker>> lockerMap;
    HashMap<Package, Locker> packageToLocker;
    int minSize;
    int maxSize;

    private void init() {
        this.minSize = 1;
        this.maxSize = 10;
        for (int size = minSize; size <= maxSize; size++) {
            lockerMap.put(size, new LinkedList<>());
        }
        for (Locker locker : lockers) {
            lockerMap.get(locker.size).add(locker);
        }
    }

    private boolean deliverPackage(Package pack) {
        for (int lockerSize = pack.size; size <= maxSize; size++) {

        }
    }
}
