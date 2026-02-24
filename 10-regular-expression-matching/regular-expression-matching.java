class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        // dp[i][j] -> s ke first i characters aur p ke first 
        // j characters match karte hain ya nahi
        boolean[][] dp = new boolean[m+1][n+1];

        // base case: empty string aur empty pattern match karte hain
        dp[0][0] = true;

        // agar string empty hai aur pattern me a*, a*b* type ho
        // to kuch cases me match possible hota hai
        for(int j = 2; j <= n; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2]; 
                // '*' apne previous character ko 0 times use kar sakta hai
            }
        }

        // main dp filling
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){

                char sch = s.charAt(i-1); // string ka current character
                char pch = p.charAt(j-1); // pattern ka current character

                // case 1: direct match ya '.' wildcard
                if(sch == pch || pch == '.'){
                    dp[i][j] = dp[i-1][j-1];
                    // previous characters match hone chahiye
                }

                // case 2: '*' mila
                else if(pch == '*'){

                    // '*' ko ignore kar do (0 occurrence)
                    dp[i][j] = dp[i][j-2];

                    // agar previous pattern character string se match karta hai
                    if(p.charAt(j-2) == sch || p.charAt(j-2) == '.'){
                        // '*' multiple characters match kar sakta hai
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }

                // case 3: characters match nahi karte
                else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}