class Solution {

    private int pick(int[] nums, int[][] dp, int idx, int rem){
        int n = nums.length;

        // end of array
        if(idx == n){
            if(rem == 0) return 0;
            return Integer.MIN_VALUE/4; // impossible state
        }

        // memo check
        if(dp[idx][rem] != Integer.MIN_VALUE) return dp[idx][rem];

        // Option 1: skip
        int skip = pick(nums, dp, idx+1, rem);

        // Option 2: take
        int newRem = (rem + nums[idx]) % 3;
        int take = nums[idx] + pick(nums, dp, idx+1, newRem);

        // best of both
        int best = Math.max(skip, take);

        dp[idx][rem] = best;
        return best;
    }


    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        // dp[idx][rem]
        int[][] dp = new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int ans = pick(nums, dp, 0, 0);
        return Math.max(ans, 0);
    }
}
