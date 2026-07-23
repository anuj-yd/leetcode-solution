class Solution {
    public int solve(int pi,int ci,int[][] pairs,int[][] dp){
        if(ci==pairs.length) return 0;

        if(dp[pi+1][ci]!=-1) return dp[pi+1][ci];
        int pick = 0;
        if(pi==-1 || pairs[pi][1]<pairs[ci][0]){
            pick = 1+solve(ci,ci+1,pairs,dp);
        }
        int skip = solve(pi,ci+1,pairs,dp);

        return dp[pi+1][ci] = Math.max(pick,skip);
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n = pairs.length;
        int[][] dp = new int[n+1][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(-1, 0, pairs, dp);
    }
}