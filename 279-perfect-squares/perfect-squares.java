class Solution {
    public int solve(int idx,int n,int[][] dp){
        if(n==0) return 0;
        if(idx*idx > n) return (int)1e9;
        if(dp[idx][n]!=-1) return dp[idx][n];
        int pick = (int)1e9;
        if(idx*idx<=n){
            pick = 1+solve(idx,n-idx*idx,dp);
        }
        int skip = solve(idx+1,n,dp);
        return dp[idx][n] = Math.min(pick,skip);
        
    }
    public int numSquares(int n) {
        int[][] dp = new int[(int)Math.sqrt(n) + 2][n + 1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(1,n,dp);
    }
}