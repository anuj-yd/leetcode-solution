class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        while(right<nums.length){
            sum+=nums[right];

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            right++;
        
        }
        return count;
        
    }
}