class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];

        for(int i=1;i<=n;i++){
            for(int isEv = 0;isEv<2;isEv++){
                if(isEv==0){
                    dp[i][isEv] = Math.max(-nums[i-1]+dp[i-1][1],dp[i-1][isEv]);
                }else{
                    dp[i][isEv] = Math.max(nums[i-1]+dp[i-1][0],dp[i-1][isEv]);
                }
            }
        }
        return Math.max(dp[n][0],dp[n][1]);
    }
}