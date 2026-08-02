class Solution {
    public int solve(int i,int j,int[] piles,Integer[][] dp){
        if(i>=j){
            if(piles[i]-piles[j]>0) return 1;
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];

        int picki = piles[i]-solve(i+1,j,piles,dp);
        int pickj = piles[j]-solve(i,j-1,piles,dp);

        return dp[i][j] = Math.max(picki,pickj);

        
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        if(n%2==1) return false;
        Integer dp[][] = new Integer[n][n];
        return solve(0,n-1,piles,dp) >= 0;
        
    }
}