package LC622;

public class MyCircularQueue {
    int k;
    int[] queue;
    int headIndex;
    int count;
    
    public MyCircularQueue(int k) {
        this.k = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (this.count == this.k)
            return false;
        this.queue[(this.headIndex + this.count) % this.k] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (this.count == 0)
            return false;
        this.headIndex = (this.headIndex + 1) % this.k;
        this.count--;
        return true;
    }
    
    public int Front() {
        return this.count == 0 ? -1 : this.queue[this.headIndex];
    }
    
    public int Rear() {
        return this.count == 0 ? -1 : this.queue[(this.headIndex + this.count) % this.k];
    }
    
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    public boolean isFull() {
        return this.count == this.k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */