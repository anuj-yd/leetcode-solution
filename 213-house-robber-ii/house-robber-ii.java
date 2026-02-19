class Solution {
    private int dfs(int[] nums,int idx,int end,int[] dp){
        if(idx>end) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int la = nums[idx]+dfs(nums,idx+2,end,dp);
        int ra = dfs(nums,idx+1,end,dp);

        return dp[idx] = Math.max(la,ra);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        //exclude last;
        int dp1[] = new int[nums.length];
        Arrays.fill(dp1,-1);
        int case1 = dfs(nums,0,n-2,dp1);

        //exclude first;
        int dp2[] = new int[nums.length];
        Arrays.fill(dp2,-1);
        int case2 = dfs(nums,1,n-1,dp2);
        return Math.max(case1,case2);

        
    }
}