class Solution {
    public boolean solve(int i,int j,String s){
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        int sp = -1;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(solve(i,j,s)){
                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return (sp!=-1 && maxLen!=Integer.MIN_VALUE) ? s.substring(sp,sp+maxLen) : "";
        
    }
}