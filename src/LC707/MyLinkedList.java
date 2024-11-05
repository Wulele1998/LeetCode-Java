package LC707;

class Node {
    public int val;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList {
    private Node head;
    
    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        Node cur = this.head;

        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return -1;
            }
            cur = cur.next;
        }

        return cur == null ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val, this.head);
        this.head = newNode;
    }
    
    public void addAtTail(int val) {
        // head can be null
        if (this.head == null) {
            head = new Node(val);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }  
    }
    
    public void addAtIndex(int index, int val) {
        Node dummyNode = new Node(-1, this.head);
        Node prev = dummyNode;
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }          
            cur = cur.next;
            prev = prev.next;  
        }
        prev.next = new Node(val, cur);
        this.head = dummyNode.next;
    }
    
    public void deleteAtIndex(int index) {
        Node dummyNode = new Node(-1, this.head);
        Node prev = dummyNode;
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }          
            cur = cur.next;
            prev = prev.next;  
        }
        // cur can be null
        if (cur != null) {
            prev.next = cur.next;
            this.head = dummyNode.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */