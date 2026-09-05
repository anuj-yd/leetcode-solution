class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        if(n<k) return 0;
        int i = 0;
        int j = 0;

        long maxSum = Long.MIN_VALUE;
        long sum = 0;

        Map<Integer,Integer> map = new HashMap<>();


        while(j<n){
            sum += nums[j];
            
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
    
            while(j-i+1>k){
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            if(j-i+1 == k && map.size()==k){
                maxSum = Math.max(sum,maxSum);
            }
            j++;
        }

        return maxSum!=Long.MIN_VALUE ? maxSum : 0;
        
    }
}