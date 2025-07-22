class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n = target-nums[i];
            if(h.containsKey(n)){
                return new int[]{i,h.get(n)};
            }
            h.put(nums[i],i);
        }
        return new int[0];
    
    }
}