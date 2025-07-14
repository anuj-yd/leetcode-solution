class Solution {
    public int evalRPN(String[] tokens){

        Stack<Integer> st = new Stack<>();

        for(String op : tokens){
            if(op.equals("+")){
                int v2 = st.pop();
                int v1 = st.pop();

                st.push(v1+v2);
            }
            else if(op.equals("-")){
                int v2 = st.pop();
                int v1 = st.pop();

                st.push(v1-v2);
            }
            else if(op.equals("*")){
                int v2 = st.pop();
                int v1 = st.pop();

                st.push(v1*v2);
            }
            else if(op.equals("/")){
                int v2 = st.pop();
                int v1 = st.pop();

                st.push(v1/v2);
            }else{
                st.push(Integer.parseInt(op));
            }
        } 
        return st.peek();
        
    }
}