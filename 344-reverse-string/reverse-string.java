class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i<=j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }



        // StringBuilder sb = new StringBuilder();
        // for(int i=0;i<s.length;i++){
        //     sb.append(s[i]);
        // }
        // String str = sb.reverse().toString();
    
        // for(int i=0;i<s.length;i++){
        //     s[i] = str.charAt(i);
        // }  
    }
}