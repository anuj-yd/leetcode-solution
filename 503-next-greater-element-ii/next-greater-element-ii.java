class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            int idx = i%n;
            while(!st.isEmpty() && nums[idx]>=st.peek()){
                st.pop();
            }
            if(idx<n){
                if(st.isEmpty()){
                    arr[idx] = -1;
                }else{
                    arr[idx] = st.peek();
                }
            }      
            st.push(nums[idx]);
        }
        return arr;
    }
}
