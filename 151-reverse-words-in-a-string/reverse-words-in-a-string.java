class Solution {
    public String reverseWords(String s){

        int i = 0;

        String[] ch = s.trim().split("\\s+");
        int j = ch.length-1;

        while(i<j){
            String temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return String.join(" ",ch);

        
    }
}