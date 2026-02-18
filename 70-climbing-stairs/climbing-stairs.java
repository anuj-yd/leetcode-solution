class Solution {
    private int finde(int n,int idx,int dp[]){
        if(idx>n) return 0;
        if(idx==n) return 1;
        if(dp[idx]!=-1) return dp[idx];
        int fs = finde(n,idx+1,dp);
        int ss = finde(n,idx+2,dp);
        return dp[idx]=fs+ss;
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return finde(n,0,dp);
    }
}