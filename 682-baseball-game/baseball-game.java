import java.util.Stack;

class Solution {
    public int calPoints(String[] operations){
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < operations.length; i++){
            String ch = operations[i];

            if(ch.equals("C")){
                st.pop();
            } else if(ch.equals("D")){
                int p = st.peek();
                st.push(p * 2);
            } else if(ch.equals("+")){
                int v2 = st.pop();
                int v1 = st.peek();
                st.push(v2); // v2 ko wapas daalna zaroori hai
                st.push(v1 + v2);
            } else {
                st.push(Integer.parseInt(ch)); // Ab number string ko integer mein badla
            }
        }

        int sum = 0;
        while(st.size()!=0){
            sum += st.pop();
        }

        return sum;
    }
}
