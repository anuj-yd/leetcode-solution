class Solution {
    public boolean checkOnesSegment(String s){
     boolean z = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                z = true;
            } else if (z && s.charAt(i) == '1') {
                return false;
            }
        }

        return true;
    }
}