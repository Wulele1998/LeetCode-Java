package OA;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;

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

    private void handlePackages() {
        for (Package pack : packages) {
            if (!deliverPackage(pack)) {
                System.out.println("Package " + pack.id + " is not delivered");
            } else {
                System.out.println("Package " + pack.id + " is delivered to locker " + packageToLocker.get(pack).id);
            }
        }
    }

    private boolean deliverPackage(Package pack) {
        for (int lockerSize = pack.size; lockerSize <= maxSize; lockerSize++) {
            if (!lockerMap.get(lockerSize).isEmpty()) {
                Locker selectedLocker = lockerMap.get(lockerSize).poll();
                packageToLocker.put(pack, selectedLocker);
                return true;
            }
        }
        System.out.println("All lockers are used, no available locker for package");
        return false;
    }

    private Locker retrievePackage(Package pack) {
        if (packageToLocker.containsKey(pack)) {
            Locker locker = packageToLocker.get(pack);
            lockerMap.get(locker.size).add(locker); // add the locker back to an available queue
            packageToLocker.remove(pack);
            return locker;
        } else {
            System.out.println("Package " + pack.id + " is not in the Lockers");
            return null;
        }
    }
}
