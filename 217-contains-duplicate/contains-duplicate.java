class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int num : nums){
            if(st.contains(num)) return true;
            st.add(num);
        }
        return false;
        
    }
}