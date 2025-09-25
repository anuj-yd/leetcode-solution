class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // initialize dp with last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // bottom-up DP
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }

        return dp[0]; // top element now contains result
    }
}