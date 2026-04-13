class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums2){
            while(!st.isEmpty() && num>= st.peek()){
                map.put(st.pop(),num);
            }
            st.add(num);
        }
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }

        int[] ans = new int[nums1.length];
        for(int i =0;i<ans.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
        
    }
}