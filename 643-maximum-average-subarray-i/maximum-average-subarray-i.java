class Solution {
    public double findMaxAverage(int[] nums, int k){
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int maxSum = sum;
        for(int j=k;j<nums.length;j++){
            sum += nums[j] - nums[j-k];

            maxSum = Math.max(maxSum,sum);
        }
        return maxSum/(double)k;
        
    }
}