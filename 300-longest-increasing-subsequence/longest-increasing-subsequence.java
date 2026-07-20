class Solution {
    public int solve(int i,int j,int[] nums,int[][] dp){
        if(j==nums.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pick = 0;

        if(nums[j]>nums[i]){
            pick = 1+solve(j,j+1,nums,dp);
        }
        int skip = solve(i,j+1,nums,dp);

        return dp[i][j] = Math.max(pick,skip);




    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int dp[][] = new int[n][n+1];

        for(int d[] : dp) Arrays.fill(d,-1);
        for(int i=0;i<n;i++){
            ans = Math.max(ans,1+solve(i,i+1,nums,dp));
        }
        return ans;
        
    }
}