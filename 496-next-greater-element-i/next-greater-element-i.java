class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums2.length];
        Arrays.fill(ans,-1);
        int n = nums2.length;
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && nums2[i]>=st.peek()){
                st.pop();
            }
            if(st.size()>0){
                ans[i] = st.peek();

            }
            st.push(nums2[i]);
        }

        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            h.put(nums2[i],ans[i]);
        }
        int arr[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            arr[i] = h.get(nums1[i]);
        }

        return arr;

        

    }
}