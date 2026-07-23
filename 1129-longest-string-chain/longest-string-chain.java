class Solution {
    public boolean isPred(int i, int j, String s1, String s2) {
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s1.length();
    }

    public int solve(int pi, int ci, String[] w, int[][] dp) {
        if (ci == w.length)
            return 0;

        if (dp[pi + 1][ci] != -1)
            return dp[pi + 1][ci];

        int pick = 0;

        if (pi == -1 || (w[ci].length() - w[pi].length() == 1 &&
                isPred(0, 0, w[pi], w[ci]))) {

            pick = 1 + solve(ci, ci + 1, w, dp);
        }
        int skip = solve(pi, ci + 1, w, dp);

        return dp[pi+1][ci] = Math.max(pick, skip);
    }

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;

        int[][] dp = new int[n+1][n];
        for(int[] d : dp) Arrays.fill(d,-1);

        return solve(-1, 0, words, dp);

    }
}