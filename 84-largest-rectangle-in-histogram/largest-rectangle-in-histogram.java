class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int [] nse = new int[n];
        int [] pse = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.empty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(!st.empty()){
                nse[i] = st.peek();
            }else{
                nse[i]=n;
            }
            st.push(i);
        }
        // empty the current stack
        while(!st.empty()) st.pop();

        Arrays.fill(pse,-1);

        for(int i=0;i<n;i++){
            while(!st.empty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }

            if(!st.empty()){
                pse[i] = st.peek();
            }
            st.push(i);
        }

        int max = -1;

        for(int i=0;i<n;i++){
            int area = heights[i]*(nse[i]-pse[i]-1);
            max = Math.max(max,area);
        }
        return max;

    }
}