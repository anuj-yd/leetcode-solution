class Solution {
    public int solve(int idx,int n,int[] dp){
        if(idx==n) return 1;
        if(idx>n) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int pick = solve(idx+1,n,dp);
        int skip = solve(idx+2,n,dp);

        return dp[idx] = pick+skip;
    }
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,dp);
        
    }
}