// class Solution {
//     int count = 0;
//     private int helper(int i,int j,String t1,String t2,Integer[][] dp){
        
//         if(i<0 || j<0) return 0;
//         int count = 0;
//         if(dp[i][j] != null) return dp[i][j]; 
//         if(t1.charAt(i)==t2.charAt(j)){
//             count = 1+ helper(i-1,j-1,t1,t2,dp);
//         }else if(t1.charAt(i)!=t2.charAt(j)){
//             int la = helper(i-1,j,t1,t2,dp);
//             int ra = helper(i,j-1,t1,t2,dp);
//             int max = Math.max(la,ra);
//             if(max>count) count = max;
//         }
//         return dp[i][j]=count;
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int i = text1.length()-1;
//         int j = text2.length()-1;
//         Integer[][] dp = new Integer[i+1][j+1];
//         return helper(i,j,text1,text2,dp);
        
//     }
// }
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(
                                    dp[i - 1][j],
                                    dp[i][j - 1]
                                 );
                }
            }
        }

        return dp[n][m];
    }
}