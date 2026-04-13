class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int nxg[] = new int[n];
        Stack<Integer> st = new Stack<>();
        nxg[n-1] = -1;
        st.push(nums2[n-1]);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()) nxg[i] = -1;
            else nxg[i] = st.peek();
            st.push(nums2[i]);
        }
        for(int i = 0;i<nums1.length;i++){

            for(int j=0;j<nums2.length;j++){

                if(nums1[i]==nums2[j]){
                    nums1[i] = nxg[j];
                    break;
                }
            }
            
        }
        return nums1;
    }
}