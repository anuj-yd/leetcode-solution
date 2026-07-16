class Solution {
    public int solve(int i,int j,int n,int m,String s1,String s2,Integer[][] dp){
        

        if(j>=m) return n-i;
        if(i>=n) return m-j;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = solve(i+1,j+1,n,m,s1,s2,dp);
        }
        int insert = 1+solve(i,j+1,n,m,s1,s2,dp);;
        int delete = 1+solve(i+1,j,n,m,s1,s2,dp);;
        int replace = 1+solve(i+1,j+1,n,m,s1,s2,dp);

        return dp[i][j]=Math.min(insert,Math.min(delete,replace));


    }
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return solve(0,0,word1.length(),word2.length(),word1,word2,dp);
        
    }
}