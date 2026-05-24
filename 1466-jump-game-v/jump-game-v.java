class Solution {
    public int solve(int[] arr,int idx,int d,int[] dp){
        int n = arr.length;
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int res = 1;
        for(int j=1;j<=d;j++){
            if(idx+j>=n || arr[idx+j]>=arr[idx]) break;
            int rjump = 1+solve(arr,idx+j,d,dp);
            res = (int)Math.max(res,rjump);
        }
        for(int j=1;j<=d;j++){
            if(idx-j<0 || arr[idx-j]>=arr[idx]) break;
            int ljump = 1+solve(arr,idx-j,d,dp);
            res = (int)Math.max(res,ljump);
        }
       
        return dp[idx]=res;
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        // int[][] dp = new int[n+1][d+1];
        // for(int[] sd : dp){
        //     Arrays.fill(sd,-1);
        // }
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            ans = (int)Math.max(ans,solve(arr,i,d,dp));
        }
        return ans==Integer.MIN_VALUE ? 0 : ans;
        
    }
}