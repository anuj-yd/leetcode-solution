class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> st = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int val : nums){
            st.add(val);
            min = Math.min(val,min);
            max = Math.max(val,max);
        }

        for(int i = min;i<=max;i++){
            if(!st.contains(i)) ans.add(i);
        }
        return ans;


        
    }
}