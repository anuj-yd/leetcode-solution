class Solution {
    // private boolean solve(int[] nums,int idx,int sum,Boolean[][] dp){
    //     if(sum==0) return true;
    //     if(idx==nums.length) return false;
    //     boolean take = false;
    //     if(nums[idx]<=sum){
    //         take = solve(nums,idx+1,sum-nums[idx],dp);
    //     }
    //     boolean skip = solve(nums,idx+1,sum,dp);
    //     return dp[idx][sum] = take || skip;
    // }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum+=n;
        boolean ans = false;
        if(sum%2!=0) return false;
        Boolean dp[][] = new Boolean[nums.length+1][sum/2+1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=sum/2;j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum/2;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{

                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][sum/2];

        // return solve(nums,0,sum/2,dp);
    }
}