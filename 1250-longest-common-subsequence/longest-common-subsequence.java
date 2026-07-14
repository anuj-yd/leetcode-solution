class Solution {

    public int solve(int i,int j,int m,int n,String text1, String text2,Integer[][] dp){
        if( i>= m || j >= n) return 0;
        if(dp[i][j]!=null) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            return 1+solve(i+1,j+1,m,n,text1,text2,dp);
        }

        int picki = solve(i+1,j,m,n,text1,text2,dp);
        int pickj = solve(i,j+1,m,n,text1,text2,dp);

        return dp[i][j]=Math.max(picki,pickj);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];

        return solve(0,0,text1.length(),text2.length(),text1,text2,dp);
    }
}