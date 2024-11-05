package LC3062;

import library.ListNode;

/**
 * LC 3062. Winner of the Linked List Game
 */
public class Solution {
    public String gameResult(ListNode head) {
        // N: the length of LinkedList
        // time: O(N)
        // space: O(1)
        int odd = 0;
        int even = 0;

        ListNode evenNode = head;
        ListNode oddNode = evenNode.next;

        while (evenNode != null) {
            if (evenNode.val > oddNode.val)
                even++;
            else if (evenNode.val < oddNode.val)
                odd++;
            
            evenNode = oddNode.next;
            if (evenNode != null)
                oddNode = evenNode.next;
        }

        if (odd > even)
            return "Odd";
        else if (odd < even) 
            return "Even";
        else 
            return "Tie";
    }
}
