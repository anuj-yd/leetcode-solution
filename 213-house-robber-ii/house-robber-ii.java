class Solution {
    public int solve(int[] arr,int idx,int n,int[] dp){

        if(idx>n) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int pick = arr[idx]+solve(arr,idx+2,n,dp);
        int skip = solve(arr,idx+1,n,dp);

        return dp[idx] = Math.max(pick,skip); 
        

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int sum1 = solve(nums,0,n-2,dp1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        int sum2 = solve(nums,1,n-1,dp2);
        return Math.max(sum1,sum2);
    }
}