class Solution {
    // public int min(int[] cost,int idx,int[] dp){
    //     if(idx>=cost.length) return 0;
    //     if(dp[idx]!=-1) return dp[idx];

    //     dp[idx] = cost[idx] + Math.min(min(cost,idx+1,dp),min(cost,idx+2,dp));
    //     return dp[idx];
    // }
    public int minCostClimbingStairs(int[] cost) {

        // int dp[] = new int[cost.length+1];
        // Arrays.fill(dp,-1);

        // return Math.min(min(cost,0,dp),min(cost,1,dp));

        
        // tabulation dp
        // int n = cost.length;
        int n = cost.length;
	    int[] dp = new int[n];
	    for (int i=0; i<n; i++) {
	    	if (i<2) dp[i] = cost[i];
	    	else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
	    }
	    return Math.min(dp[n-1], dp[n-2]);
        // return (int)Math.min(dp[n-1],dp[n-2]);
        
    }
}