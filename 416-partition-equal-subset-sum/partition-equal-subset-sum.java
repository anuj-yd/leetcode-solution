class Solution {
    // 1d
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}

    // public boolean check(int[] nums,Boolean[][] dp,int sum,int idx){
    //     if(idx==0) return false;
    //     if(sum==0) return true;

    //      if(dp[idx][sum] != null) return dp[idx][sum];

    //     boolean pick = false;

    //     if(nums[idx-1]<=sum){
    //         pick = check(nums,dp,sum-nums[idx-1],idx-1);
            
    //     }
    //     boolean skip = check(nums,dp,sum,idx-1);
    //     return dp[idx][sum] = pick || skip;

    // }
    // 2d dp
    // public boolean canPartition(int[] nums) {
    //     int n = nums.length;
    //     int sum = 0;
    //     for(int num : nums) sum+=num;
    //     Boolean[][] dp = new Boolean[n+1][sum/2 + 1];
    //     if(sum%2!=0) return false;

    //     for(int i = 0; i <= n; i++){
    //         dp[i][0] = true;
    //     }

    //     for(int j = 1; j <= sum/2; j++){
    //         dp[0][j] = false;
    //     }

    //     for(int i=1;i<n+1;i++){
    //         for(int j = 1;j<sum/2+1;j++){
    //             if(nums[i-1]<=j){
    //                 dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
    //             }else{
    //                 dp[i][j] = dp[i-1][j];
    //             }
    //         }
    //     }
    //     return dp[n][sum/2];
        // return check(nums,dp,sum/2,n);
