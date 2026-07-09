class Solution {
    public int solve1(int idx,int[] arr,int[] dp){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int j1 = solve1(idx+1,arr,dp);
        int j2 = solve1(idx+2,arr,dp);

        dp[idx] = arr[idx]+Math.min(j1,j2);
        
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