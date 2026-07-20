class Solution {
    public int solve(int i,int nums[],int n,int dp[]){
        if(i>n) return 0;

        if(dp[i]!=-1) return dp[i];

        int pick = nums[i] + solve(i+2,nums,n,dp);
        int skip = solve(i+1,nums,n,dp);

        return dp[i] = Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[101];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[101];
        Arrays.fill(dp2,-1);
        int s1 = solve(0,nums,n-2,dp1);
        int s2 = solve(1,nums,n-1,dp2);

        return Math.max(s1,s2);
        
    }
}