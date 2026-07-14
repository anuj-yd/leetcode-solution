class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[2500][2501];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                int pick = 0;
                if (nums[j] > nums[i]) {
                    pick = 1;
                    if (j + 1 < n) {
                        pick += dp[j][j + 1];
                    }
                }
                int skip = dp[i][j + 1];
                dp[i][j] = Math.max(pick, skip);
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, 1 + dp[i][i + 1]);
        }
        return ans;
    }
}