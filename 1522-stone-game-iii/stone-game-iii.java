class Solution {
    public int solve(int idx,int n,int nums[],int[] dp){
        if(idx==n) return 0;
        if(dp[idx]!=Integer.MIN_VALUE) return dp[idx];
        int pick = 0;
        for(int i=idx;i<Math.min(idx+3,n);i++){
            pick += nums[i];
            dp[idx] = Math.max(dp[idx], pick - solve(i + 1, n, nums,dp));
        }
        return dp[idx];
    }
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);

        int ans = solve(0,n,stoneValue,dp);

        if(ans > 0){
            return "Alice";
        }else if(ans < 0){

            return "Bob";
        }else{
            return "Tie";
        }
        
    }
}