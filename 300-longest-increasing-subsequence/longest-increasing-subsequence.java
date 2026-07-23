class Solution {

    // public int solve(int pi,int ci,int[] nums,int[][] dp){
    //     if(ci==nums.length) return 0;

    //     if(dp[pi+1][ci]!=-1) return dp[pi+1][ci];

    //     int pick = 0;

    //     if(pi==-1 || nums[pi]<nums[ci]){
    //         pick = 1+solve(ci,ci+1,nums,dp);
    //     }
    //     int skip = solve(pi,ci+1,nums,dp);

    //     return dp[pi+1][ci] = Math.max(pick,skip);
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int dp[][] = new int[n][n];
        int t[] = new int[n];
        Arrays.fill(t,1);

        // for(int[] d : dp) Arrays.fill(d,-1);
        int maxLen = 1;
        for(int i=0;i<n;i++){

           for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    t[i] = Math.max(t[i],t[j]+1);
                    maxLen = Math.max(maxLen,t[i]);
                }
           }
            
        }
        return maxLen;
        
    }
}