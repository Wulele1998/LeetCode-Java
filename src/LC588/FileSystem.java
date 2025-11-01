package LC588;

import java.util.*;

/**
 * LC 588. Design In-Memory File System
 */
public class FileSystem {

    class FileNode {
        boolean isFile;
        HashMap<String, FileNode> children;
        StringBuilder content;
        FileNode() {
            this.isFile = false;
            this.children = new HashMap<>();
            this.content = new StringBuilder();
        }
    }

    FileNode root;
    FileNode current;

    public FileSystem() {
        this.root = new FileNode();
    }

    public List<String> ls(String path) {
        List<String> fileList = new ArrayList<>();
        current = root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i++) {
            current = current.children.get(dirs[i]);
        }
        if (current.isFile) {
            fileList.add(dirs[dirs.length - 1]);
        } else {
            fileList.addAll(current.children.keySet());
            Collections.sort(fileList);
        }
        return fileList;
    }

    public void mkdir(String path) {
        current = root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i++) {
            // skip the first empty directory
            if (!current.children.containsKey(dirs[i])) {
                current.children.put(dirs[i], new FileNode());
            }
            current = current.children.get(dirs[i]); // move to next level of the trie
        }
    }

    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        current.content.append(content);
        current.isFile = true;
    }

    public String readContentFromFile(String filePath) {
        current = root;
        String[] dirs = filePath.split("/");
        for (int i = 1; i < dirs.length; i++) {
            current = current.children.get(dirs[i]);
        }
        return current.content.toString();
    }
}
