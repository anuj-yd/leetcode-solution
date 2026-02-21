class Solution {
    public String longestPalindrome(String s) {

    if (s == null || s.length() == 0) return "";

    // 🔹 Step 1: Transform string
    // Example: "abba" -> "^#a#b#b#a#$"
    StringBuilder sb = new StringBuilder();
    sb.append("^");        // start sentinel

    for (int i = 0; i < s.length(); i++) {
        sb.append("#");
        sb.append(s.charAt(i));
    }

    sb.append("#$");       // end sentinel

    String str = sb.toString();
    int n = str.length();

    int[] P = new int[n];  // palindrome radius array
    int center = 0;
    int right = 0;

    // 🔹 Step 2: Single loop
    for (int i = 1; i < n - 1; i++) {

        int mirror = 2 * center - i;

        if (i < right) {
            P[i] = Math.min(right - i, P[mirror]);
        }

        // 🔹 Try expanding
        while (str.charAt(i + 1 + P[i]) ==
               str.charAt(i - 1 - P[i])) {
            P[i]++;
        }

        // 🔹 Update center and right
        if (i + P[i] > right) {
            center = i;
            right = i + P[i];
        }
    }
    // 🔹 Find max palindrome
    int maxLen = 0;
    int centerIndex = 0;
    for (int i = 1; i < n - 1; i++) {
        if (P[i] > maxLen) {
            maxLen = P[i];
            centerIndex = i;
        }
    }
    // 🔹 Extract original substring
    int start = (centerIndex - maxLen) / 2;
    return s.substring(start, start + maxLen);
    }
}