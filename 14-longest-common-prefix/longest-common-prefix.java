class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}