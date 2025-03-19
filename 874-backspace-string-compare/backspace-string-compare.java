class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                sb.append(c);
            }else if (sb.length() > 0) {  
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#') {
                sb1.append(c);
            }else if (sb1.length() > 0) {  
                sb1.deleteCharAt(sb1.length() - 1);
            }
        }
        return sb.toString().equals(sb1.toString());
    }
}