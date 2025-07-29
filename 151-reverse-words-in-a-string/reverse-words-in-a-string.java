class Solution {
    public String reverseWords(String s){

        // int i = 0;

        String[] ch = s.trim().split("\\s+");
        int j = ch.length;

        // while(i<j){
        //     String temp = ch[i];
        //     ch[i] = ch[j];
        //     ch[j] = temp;
        //     i++;
        //     j--;
        // }
        // return String.join(" ",ch);

        for(int i=0;i<j/2;i++){
            String temp = ch[i];
            ch[i] = ch[j-i-1];
            ch[j-i-1] = temp;
        
        }
        return String.join(" ",ch);

        
    }
}