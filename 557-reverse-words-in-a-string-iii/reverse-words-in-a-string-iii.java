class Solution {
    public String reverseWords(String s){
        String [] snew = s.split(" ");
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<snew.length;i++){
            StringBuilder sb = new StringBuilder(snew[i]);
            sb1.append(sb.reverse()).append(" ");
            
        }
        return sb1.toString().trim();        
        
        
        
    }
}