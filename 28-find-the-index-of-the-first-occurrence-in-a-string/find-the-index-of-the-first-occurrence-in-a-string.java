class Solution {
    public int strStr(String haystack, String needle) {

        char[] ch = haystack.toCharArray(); // ✅ fixed: capital 'C'
        char[] nd = needle.toCharArray();

        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && ch[i + j] == nd[j]) {
                j++;
            }
            if (j == m) {
                return i; // ✅ match found
            }
        }
        return -1; // ✅ no match
    }

    // return haystack.indexOf(needle);
}
