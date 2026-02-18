class Solution {
    
    private boolean dfs(Boolean[] dp, int[] nums, int idx) {
        
        // Base case
        if (idx >= nums.length - 1) return true;
        
        // If already computed
        if (dp[idx] != null) return dp[idx];
        
        for (int j = 1; j <= nums[idx]; j++) {
            
            if (idx + j < nums.length) {
                
                boolean ans = dfs(dp, nums, idx + j);
                
                if (ans) {
                    dp[idx] = true;
                    return true;
                }
            }
        }
        
        dp[idx] = false;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return dfs(dp, nums, 0);
    }
}