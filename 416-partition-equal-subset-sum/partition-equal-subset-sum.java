class Solution {
    public boolean check(int[] nums,Boolean[][] dp,int sum,int idx){
        if(idx==0) return false;
        if(sum==0) return true;

         if(dp[idx][sum] != null) return dp[idx][sum];

        boolean pick = false;

        if(nums[idx-1]<=sum){
            pick = check(nums,dp,sum-nums[idx-1],idx-1);
            
        }
        boolean skip = check(nums,dp,sum,idx-1);
        return dp[idx][sum] = pick || skip;

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum+=num;
        Boolean[][] dp = new Boolean[n+1][sum/2 + 1];
        if(sum%2!=0) return false;
        return check(nums,dp,sum/2,n);

        
    }
}