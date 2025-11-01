package LC1166;

import java.util.HashMap;

public class FileSystem {
    HashMap<String, Integer> map;
    public FileSystem() {
        this.map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (this.map.containsKey(path)) {
            return false;
        }

        // path length >= 2
        int index = path.lastIndexOf("/");
        String parentPath = path.substring(0, index);
        if (index == 0 || this.map.containsKey(parentPath)) {
            map.put(path, value);
            return true;
        } else {
            return false;
        }
    }

    public int get(String path) {
        return this.map.getOrDefault(path, -1);
    }
}
