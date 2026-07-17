class Solution {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[1001][1001];
        int count = 0;
        int n = s.length();
        // length of substrigs
        for(int l=1;l<=n;l++){
        
            for(int i=0;i+l-1<n;i++){

                int j = i+l-1;

                // l1
                if(i==j){
                    dp[i][j] = true;
                }

                //l2
                else if(i+1==j){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }
                // l>=3
                else{
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) && (dp[i+1][j-1]);
                }

                // check palindrome

                if(dp[i][j]==true) count++;

            }
        }
        return count;

        
    }
}