class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[1001][1001];

        int sp = -1;
        int len = Integer.MIN_VALUE;

        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n;i++){

                int j = i+l-1;

                //l1
                if(i==j){
                    dp[i][j]=true;
                }
                //l2
                else if(i+1==j){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }
                //l>=3
                else{

                    dp[i][j] = (s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];

                }

                if(dp[i][j]==true){
                    sp = i;
                    len = j-i+1;
                }
            }
        }

        return (sp!=-1 && len!=Integer.MIN_VALUE) ? s.substring(sp,sp+len) : "";
        
    }
}