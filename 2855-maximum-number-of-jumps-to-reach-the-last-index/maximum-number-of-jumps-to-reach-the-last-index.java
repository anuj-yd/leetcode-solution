class Solution {

    int[][] dp;

    public int solve(int[] nums, int tar, int idx, int j) {

        int n = nums.length;

        if (idx == n-1) return 0;

        if (j >= n) return Integer.MIN_VALUE;

        if (dp[idx][j] != -1) return dp[idx][j];

        int pick = Integer.MIN_VALUE;

        int diff = nums[j] - nums[idx];
        if (-tar <= diff && diff <= tar) {
            int next = solve(nums, tar, j, j + 1);
            if (next != Integer.MIN_VALUE) {
                pick = 1 + next;
            }
        }
        int skip = solve(nums, tar, idx, j + 1);

        return dp[idx][j] = Math.max(pick, skip);
    }

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(nums, target, 0, 1);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}