class Solution {
    private int atMost(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int count = 0;

        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;

    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);  
    }
}