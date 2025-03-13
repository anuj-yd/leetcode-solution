class Solution{
    public boolean isVowel(char st){
        if(st=='a'||st=='e'||st=='i'||st=='o'||st=='u'||st=='A'||st=='E'||st=='I'||st=='O'||st=='U'){
            return true;
        }
        return false;

    }   
    public String reverseVowels(String s){
        char c[] = s.toCharArray();
        int j=c.length-1;
        int i=0;
        while(i<j){
            if(isVowel(c[i]) && isVowel(c[j])){
                char temp = c[i];
                c[i]=c[j];
                c[j]=temp;
                i++;
                j--;
            }else{
                if(isVowel(c[i])){
                    j--;
                }else if(isVowel(c[j])){
                    i++;
                }else{
                    i++;
                    j--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<c.length;k++){
            sb.append(c[k]);
        }
        return sb.toString();
    }
}