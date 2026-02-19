import java.util.*;

class Solution {
    
    private int helper(int[] dp, String s, int idx) {
        
        // Base case
        if (idx == s.length()) return 1;
        
        // If starts with 0 → invalid
        if (s.charAt(idx) == '0') return 0;
        
        if (dp[idx] != -1) return dp[idx];
        
        // Take single digit
        int take = helper(dp, s, idx + 1);
        
        int skip = 0;
        
        // Take two digits
        if (idx + 1 < s.length()) {
            int num = (s.charAt(idx) - '0') * 10 
                      + (s.charAt(idx + 1) - '0');
            
            if (num <= 26) {
                skip = helper(dp, s, idx + 2);
            }
        }
        
        return dp[idx] = take + skip;
    }
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(dp, s, 0);
    }
}