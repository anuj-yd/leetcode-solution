class Solution {
    public int solve(int i,int j,int n,int[] nums,Integer[][] dp){
        if(j>=n) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int pick = 0;
        if(nums[j]>nums[i]){
            pick = 1+solve(j,j+1,n,nums,dp);
        }
        int skip = solve(i,j+1,n,nums,dp);

        return dp[i][j] = Math.max(pick,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Integer dp[][] = new Integer[n][n];
        int ans = 1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,1+solve(i,i+1,n,nums,dp));
        }
        return ans;
    }
}