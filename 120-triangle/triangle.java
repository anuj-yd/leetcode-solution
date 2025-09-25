// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[] dp = new int[n];

//         // initialize dp with last row
//         for (int i = 0; i < n; i++) {
//             dp[i] = triangle.get(n - 1).get(i);
//         }

//         // bottom-up DP
//         for (int row = n - 2; row >= 0; row--) {
//             for (int col = 0; col <= row; col++) {
//                 dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
//             }
//         }

//         return dp[0]; // top element now contains result
//     }
// }

class Solution {
    int m;
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> tran) {
        m = tran.size();
        dp = new Integer[m][m];
       
        return helper(tran,0,0);
    }
    int helper(List<List<Integer>> tran,int row, int col){
        if(row==m){
            return 0;
        }
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        int left = helper(tran,row+1,col);
        int right = helper(tran,row+1,col+1);
        return dp[row][col]=tran.get(row).get(col) + Math.min(left,right);
    }
}