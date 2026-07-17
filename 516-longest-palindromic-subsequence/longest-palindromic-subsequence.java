class Solution {
    public int isPalin(String s,int i,int j,Integer[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;

        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = 2+isPalin(s,i+1,j-1,dp);
        }

        return dp[i][j] = Math.max(isPalin(s,i+1,j,dp),isPalin(s,i,j-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        Integer[][] dp = new Integer[1001][1001];

        return isPalin(s,0,n-1,dp);


    }
}