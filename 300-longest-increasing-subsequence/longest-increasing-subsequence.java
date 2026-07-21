class Solution {

    int n;
    int[][] dp;

    public int lis(int[] nums, int prevIdx, int currIdx) {

        if (currIdx == n)
            return 0;

        if (prevIdx != -1 && dp[prevIdx][currIdx] != -1)
            return dp[prevIdx][currIdx];

        int taken = 0;

        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            taken = 1 + lis(nums, currIdx, currIdx + 1);
        }

        int notTaken = lis(nums, prevIdx, currIdx + 1);

        if (prevIdx != -1)
            dp[prevIdx][currIdx] = Math.max(taken, notTaken);

        return Math.max(taken, notTaken);
    }

    public int lengthOfLIS(int[] nums) {

        n = nums.length;

        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return lis(nums, -1, 0);
    }
}