import java.util.*;

class Solution {

    public int helper(int[][] dp, int sr, int sc, int dr, int dc) {
        if (sr > dr || sc > dc) return 0;
        if (sr == dr && sc == dc) return 1;
        if (dp[sr][sc] != -1) return dp[sr][sc];
        int right = helper(dp, sr, sc + 1, dr, dc);
        int down = helper(dp, sr + 1, sc, dr, dc);
        return dp[sr][sc] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(dp, 0, 0, m - 1, n - 1);
    }
}