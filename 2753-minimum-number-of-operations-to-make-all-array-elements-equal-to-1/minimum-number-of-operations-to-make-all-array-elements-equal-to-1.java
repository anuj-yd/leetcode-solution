class Solution {
    // standard gcd
    private int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        // count existing ones
        int ones = 0;
        for (int v : nums) if (v == 1) ones++;
        if (ones > 0) return n - ones; // fastest path

        // find shortest subarray with gcd == 1
        int bestLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            if (g == 1) { bestLen = 1; break; } // defensive (though handled above)
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    bestLen = Math.min(bestLen, j - i + 1);
                    break; // for this i, we found shortest j
                }
            }
        }

        if (bestLen == Integer.MAX_VALUE) return -1; // no subarray with gcd 1

        // (bestLen - 1) to create one '1', then (n - 1) to propagate it
        return (bestLen - 1) + (n - 1);
    }
}
