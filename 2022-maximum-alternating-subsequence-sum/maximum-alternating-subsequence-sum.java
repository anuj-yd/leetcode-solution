class Solution {
    public long solve(int i,int[] nums,long[][] dp,int isEv){
        if(i==nums.length) return 0;

        if(dp[i][isEv]!=-1) return dp[i][isEv];

        long pick = 0;

        if(isEv==0){
            pick = nums[i]+solve(i+1,nums,dp,1);
        }else{
            pick = -nums[i]+solve(i+1,nums,dp,0);
        }

        long skip = solve(i+1,nums,dp,isEv);

        return dp[i][isEv] = Math.max(pick,skip);
    }
    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(long[] d : dp) Arrays.fill(d,-1);
        return solve(0,nums,dp,0);
        
    }
}