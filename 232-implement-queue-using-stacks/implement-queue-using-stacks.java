class MyQueue {
    private Stack<Integer> st;
    private Stack<Integer> gt;

    public MyQueue() {
        st = new Stack<>();
        gt = new Stack<>();
        
    }
    public void push(int x){
        
        st.push(x);
        
        
    }
    
    public int pop() {
        while(st.size()>1){
            gt.push(st.pop());
        }
        int x = st.pop();
        while(gt.size()>0){
            st.push(gt.pop());
        }

        return x;
    }
    
    public int peek() {
        while(st.size()>1){
            gt.push(st.pop());
        }
        int x = st.peek();
        while(gt.size()>0){
            st.push(gt.pop());
        }

        return x;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */