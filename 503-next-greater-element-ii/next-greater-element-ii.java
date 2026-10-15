class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        

        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            int c = i%n;

            while(!st.isEmpty() && nums[c]>=st.peek()){
                st.pop();
            }
            
            if(c<n){
                if(st.isEmpty()){
                    ans[c] = -1;
                }else{
                    ans[c] = st.peek();
                }
            }
            st.push(nums[c]);
            


        }
        return ans;
        
    }
}