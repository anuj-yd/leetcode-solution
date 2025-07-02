class Solution {
    public int climbStairs(int n) {
        
    int[] memo = new int[n + 1];
        return climb(n, memo);
    }

    private int climb(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;

        if (memo[n] != 0) return memo[n];  // Already computed

        memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
        return memo[n];
    }
}