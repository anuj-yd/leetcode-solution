class Solution {
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        Arrays.fill(ans,0);
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }

            if(!st.empty()){
                ans[i] = st.peek()-i;
            }
            st.push(i);

        }
        return ans;
        
    }
}