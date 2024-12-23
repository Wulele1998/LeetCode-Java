package LC2337;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    Character character;
    int index;

    public Node(Character character, int index) {
        this.character = character;
        this.index = index;
    }
}

public class Solution2 {
    public boolean canChange(String start, String target) {
        // N: the length of string
        // time: O(N)
        // space: O(N)
        Queue<Node> queueStart = new LinkedList<>();
        Queue<Node> queueTarget = new LinkedList<>();

        for (int i = 0; i < start.length(); i++) {
            queueStart.add(new Node(start.charAt(i), i));
            queueTarget.add(new Node(target.charAt(i), i));
        }

        if (queueStart.size() != queueTarget.size()){
            return false;
        }

        while (!queueStart.isEmpty()) {
            Node curStart = queueStart.poll();
            Node curTarget = queueTarget.poll();

            if (curStart == null || curTarget == null) {
                return false;
            }

            if (curStart.character == curTarget.character) {
                if (curStart.character == 'L' && curStart.index < curTarget.index) {
                    return false;
                }
                if (curStart.character == 'R' && curStart.index > curTarget.index) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;

    }
}
