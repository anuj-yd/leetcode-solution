class Solution {
    public int solve(int idx, int[] coins, int amount, Integer[][] dp) {
        int n = coins.length;

        if (amount == 0) return 0;
        if (idx == n) return Integer.MAX_VALUE;

        if (dp[idx][amount] != null) return dp[idx][amount];

        int pick = Integer.MAX_VALUE;

        if (coins[idx] <= amount) {
            int res = solve(idx, coins, amount - coins[idx], dp);
            if (res != Integer.MAX_VALUE) {
                pick = 1 + res;
            }
        }

        int skip = solve(idx + 1, coins, amount, dp);

        return dp[idx][amount] = Math.min(pick, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];

        int ans = solve(0, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}