class Solution {
    public int solve(int i,int j,int n,int m,String s, String t,int[][] dp){
        if(j==m) return 1;
        if(i==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            int take = solve(i + 1, j + 1, n, m, s, t,dp);
            int skip = solve(i + 1, j, n, m, s, t,dp);

            return dp[i][j] = take + skip;
        }
        return dp[i][j] = solve(i+1,j,n,m,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d,-1);

        return solve(0,0,n,m,s,t,dp);
        
    }
}