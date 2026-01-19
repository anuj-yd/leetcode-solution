class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Prefix sum matrix
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(pre, mid, threshold, m, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[][] pre, int len, int threshold, int m, int n) {
        for (int i = 0; i + len <= m; i++) {
            for (int j = 0; j + len <= n; j++) {
                int sum = pre[i + len][j + len]
                        - pre[i][j + len]
                        - pre[i + len][j]
                        + pre[i][j];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
