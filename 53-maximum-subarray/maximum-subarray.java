class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int cSum = 0;
        for(int num : nums){
            cSum += num;
            maxSum = Math.max(maxSum,cSum);
            if(cSum<0) cSum = 0;
        }
        return maxSum;
    }
}