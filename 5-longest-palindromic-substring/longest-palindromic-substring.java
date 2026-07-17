class Solution {
    public boolean isPalin(int i,int j,String s,Boolean[][] dp){
        if(i>=j) return true;

        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = isPalin(i+1,j-1,s,dp);
        }

        return dp[i][j] = false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[1001][1001];

        int sp = -1;
        int len = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalin(i,j,s,dp) && j-i+1 > len){
                    sp = i;
                    len = j-i+1;
                }
            }
        }

        return (sp!=-1 && len!=Integer.MIN_VALUE) ? s.substring(sp,sp+len) : "";
        
    }
}