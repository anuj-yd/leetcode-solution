class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums,nums.length-1,dp);
        
    }
    private int dfs(int[] nums,int idx,int[] dp){
        if(idx<0) return 0;
        if(idx==0) return dp[idx]=nums[0];

        if(dp[idx]!=-1) return dp[idx];
        int la = nums[idx]+dfs(nums,idx-2,dp);
        int ra = 0+dfs(nums,idx-1,dp);
        return dp[idx] = Math.max(la,ra);
    }
}