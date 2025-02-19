class Solution {
    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder();
        String str1=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c = str1.charAt(i);
            if(Character.isLetter(c)||Character.isDigit(c)){
                sb.append(c);
            }
        }
    
        return sb.toString().equals(sb.reverse().toString());
    }
}