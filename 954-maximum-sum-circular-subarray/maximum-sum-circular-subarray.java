class Solution {

    
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int tsum = 0;
        int minSum = Integer.MAX_VALUE;
        int csum = 0;
        int maxSum = Integer.MIN_VALUE;
        int mSum = 0;
        for(int i=0;i<n;i++){
            tsum += nums[i];

            mSum = Math.max(mSum+nums[i],nums[i]);
            maxSum = Math.max(mSum,maxSum);


            csum = Math.min(csum+nums[i],nums[i]);
            minSum = Math.min(csum,minSum); 


        }
        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum,tsum-minSum);

        
        
    }
}