class Solution {
    public String reverseOnlyLetters(String s){
        char ch[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(Character.isLetter(ch[i])){
                sb.append(ch[i]);
                
            }
        }
        sb.reverse();
        for(int i=0;i<ch.length;i++){
            if(!Character.isLetter(ch[i])){
                sb.insert(i,ch[i]);
            }
        }
        return sb.toString();
        
    }
}