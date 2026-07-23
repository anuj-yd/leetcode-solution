class Solution {

    public int solve(int pi,int ci,int[] nums,int[][] dp){
        if(ci==nums.length) return 0;

        if(dp[pi+1][ci]!=-1) return dp[pi+1][ci];

        int pick = 0;

        if(pi==-1 || nums[pi]<nums[ci]){
            pick = 1+solve(ci,ci+1,nums,dp);
        }
        int skip = solve(pi,ci+1,nums,dp);

        return dp[pi+1][ci] = Math.max(pick,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];


        for(int[] d : dp) Arrays.fill(d,-1);

        return solve(-1,0,nums,dp);
        
    }
}