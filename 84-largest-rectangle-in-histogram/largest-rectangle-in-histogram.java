class Solution {
    public void solve1(int[] nse,int[] arr,int n){
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = st.peek();
            }

            st.push(i);
        }
        
        
    }
    public void solve2(int[] pse,int[] arr,int n){
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }

            st.push(i);
        }

    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) return heights[0];
        int[] nse = new int[n];

        int[] pse = new int[n];
        solve1(nse,heights,n);
        solve2(pse,heights,n);

        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            int curr = heights[i] * width;

            max = Math.max(max,curr);
        }

        return max;
    }
}