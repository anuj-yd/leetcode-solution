class MinStack {

    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {

        if(!st.isEmpty() && st.peek()[1]<value){
            st.push(new int[]{value,st.peek()[1]});
        }else{
            st.push(new int[]{value,value});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */