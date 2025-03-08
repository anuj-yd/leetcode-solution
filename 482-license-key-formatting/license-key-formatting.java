class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase().replace("-", "");
        StringBuilder sb = new StringBuilder(s);

        for (int i = sb.length() - k; i > 0; i -= k) {
            sb.insert(i, '-');
        }

        return sb.toString();
    }
}