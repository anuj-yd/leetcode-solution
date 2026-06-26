class MyCircularQueue {

    int f,r,sz,cap;
    int[] ans;

    public MyCircularQueue(int k) {
        cap = k; ans = new int[k];
        f = 0; r = 0; sz = 0;
    }
    
    public boolean enQueue(int value) {
        if(sz == cap) return false;
        ans[r] = value;
        r = (r+1)%cap;
        sz++; 
        return true;
    }
    
    public boolean deQueue() {
        if(sz == 0) return false;
        f = (f+1)%cap;
        sz--;
        return true;
    }
    
    public int Front() {
        if(sz==0) return -1;
        return ans[f];
    }
    
    public int Rear() {
        if(sz==0) return -1;
        int idx = (r-1+cap)%cap;
        return ans[idx];
    }
    
    public boolean isEmpty() {
        return sz==0;
    }
    
    public boolean isFull() {
        return sz == cap;
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