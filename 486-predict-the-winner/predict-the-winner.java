class Solution {

    public int solve(int i, int j, int[] nums, Integer[][] dp) {

        if(i > j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int left = nums[i] - solve(i + 1, j, nums, dp);
        int right = nums[j] - solve(i, j - 1, nums, dp);

        dp[i][j] = Math.max(left, right);

        return dp[i][j];
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        Integer[][] dp = new Integer[n][n];

        return solve(0, n - 1, nums, dp) >= 0;
    }
}