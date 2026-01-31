package LC1756;

public class MRUQueue2 {
    // use linked list
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head;
    ListNode tail;
    public MRUQueue2(int n) {
        head = new ListNode(0);
        tail = head;
        for (int i = 1; i <= n; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
    }

    // O(K)
    public int fetch(int k) {
        ListNode cur = head;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }

        ListNode target = cur.next;
        tail.next = target;
        tail = tail.next;
        cur.next = target.next;
        tail.next = null;

        return target.val;
    }
}
