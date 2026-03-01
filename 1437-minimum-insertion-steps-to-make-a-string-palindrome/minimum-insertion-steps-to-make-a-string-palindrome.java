class Solution {
    public int solve(String s,String p,int i,int j,Integer[][] dp){
        if(i==0||j==0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i-1)==p.charAt(j-1)){
            dp[i][j] = 1+solve(s,p,i-1,j-1,dp);
        }else{
            dp[i][j] = Math.max(solve(s,p,i-1,j,dp),solve(s,p,i,j-1,dp));
        }
        return dp[i][j];
    }
    public int minInsertions(String s) {
        int n = s.length();
        String p = new StringBuilder(s).reverse().toString();
        Integer dp[][] = new Integer[n+1][n+1];
        return n-solve(s,p,n,n,dp);
        
    }
}