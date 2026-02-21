class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return "";

        String res = "";
        int max = 0;

        for (int ax = 0; ax < s.length(); ax++) {

            // ODD length
            int len = 1;
            int r = 1;

            while (ax - r >= 0 &&
                   ax + r < s.length() &&
                   s.charAt(ax - r) == s.charAt(ax + r)) {

                len += 2;
                r++;
            }

            if (len > max) {
                max = len;
                int start = ax - (len / 2);
                res = s.substring(start, start + len);
            }

            // EVEN length
            len = 0;
            r = 1;

            while (ax - r + 1 >= 0 &&
                   ax + r  < s.length() &&
                   s.charAt(ax - r + 1) == s.charAt(ax + r)) {

                len += 2;
                r++;
            }

            if (len > max) {
                max = len;
                int start = ax - (len / 2) + 1;
                res = s.substring(start, start + len);
            }
        }

        return res;
    }
}