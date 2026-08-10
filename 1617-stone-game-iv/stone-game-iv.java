class Solution {
    public boolean solve(int n,Boolean[] dp){
        if(n==0){
            return false;
        }
        if(dp[n]!=null) return dp[n];
        for(int i=1;i*i<=n;i++){
            if(solve(n - (i * i),dp) == false) {
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
    public boolean winnerSquareGame(int n) {
        if(n==1) return true;
        Boolean dp[] = new Boolean[n+1];
        return solve(n,dp);
        
    }
}