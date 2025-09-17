class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(m, n);
    }

    private int solve(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (dp[m][n] != -1) return dp[m][n]; 
        dp[m][n] = solve(m - 1, n) + solve(m, n - 1); 
        return dp[m][n];
    }
}
