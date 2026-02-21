class Solution {
    int count = 0;
    private int helper(int i,int j,String t1,String t2,Integer[][] dp){
        
        if(i<0 || j<0) return 0;
        int count = 0;
        if(dp[i][j] != null) return dp[i][j]; 
        if(t1.charAt(i)==t2.charAt(j)){
            count = 1+ helper(i-1,j-1,t1,t2,dp);
        }else if(t1.charAt(i)!=t2.charAt(j)){
            int la = helper(i-1,j,t1,t2,dp);
            int ra = helper(i,j-1,t1,t2,dp);
            int max = Math.max(la,ra);
            if(max>count) count = max;
        }
        return dp[i][j]=count;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length()-1;
        int j = text2.length()-1;
        Integer[][] dp = new Integer[i+1][j+1];
        return helper(i,j,text1,text2,dp);
        
    }
}