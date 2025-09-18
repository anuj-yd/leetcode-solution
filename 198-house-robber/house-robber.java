class Solution {

    // public int maxLoot(int[] nums,int idx,int[] dp){
    //     if(idx>=nums.length) return 0;
    //     if(dp[idx]!=-1) return dp[idx];
    //     int steal = nums[idx]+maxLoot(nums,idx+2,dp);
    //     int skip = maxLoot(nums,idx+1,dp);
    //     return dp[idx] = Math.max(steal,skip);
    // }
    public int rob(int[] nums) {
        // int n = nums.length;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return maxLoot(nums,0,dp);
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
        
    }
}