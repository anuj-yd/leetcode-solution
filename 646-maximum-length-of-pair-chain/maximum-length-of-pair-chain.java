import java.util.Arrays;

class Solution {

    int[][] dp;
    int n;

    public int solve(int prevIndex, int currIndex, int[][] pairs) {

        if (currIndex == n)
            return 0;

        if (prevIndex != -1 && dp[prevIndex][currIndex] != -1)
            return dp[prevIndex][currIndex];

        int pick = 0;

        if (prevIndex == -1 || pairs[prevIndex][1] < pairs[currIndex][0]) {
            pick = 1 + solve(currIndex, currIndex + 1, pairs);
        }

        int skip = solve(prevIndex, currIndex + 1, pairs);

        if (prevIndex != -1)
            dp[prevIndex][currIndex] = Math.max(pick, skip);

        return Math.max(pick, skip);
    }

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);

        n = pairs.length;
        dp = new int[1001][1001];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(-1, 0, pairs);
    }
}