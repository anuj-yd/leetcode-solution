class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int ones = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ones++;
            } else if (i == n - 1 || s.charAt(i + 1) == '1') {
                // this '0' ends a zero-block (next is '1' or end), so every previous '1'
                // can be moved across this zero-block exactly once (count them).
                ans += ones;
            }
        }
        return ans;
    }
}
