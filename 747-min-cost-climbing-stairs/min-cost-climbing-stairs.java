class Solution {
    public int solve1(int idx,int[] arr,int[] dp){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];

        dp[idx] = arr[idx]+Math.min(solve1(idx+1,arr,dp),solve1(idx+2,arr,dp));

        return dp[idx];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        int min1 = solve1(0,cost,dp);
        int min2 = solve1(1,cost,dp);
        return Math.min(min1,min2);
    }
}