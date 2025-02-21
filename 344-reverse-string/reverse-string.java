class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length;i++){
            sb.append(s[i]);
        }
        String str = sb.reverse().toString();
    
        for(int i=0;i<s.length;i++){
            s[i] = str.charAt(i);
        }  
    }
}