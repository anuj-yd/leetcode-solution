class Solution {
    private int stock(int idx,int buy,int[] arr,int dp[][]){
        int profit = 0;
        int n = arr.length;
        if(idx==n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            int pick = profit-arr[idx]+stock(idx+1,0,arr,dp);
            int skip = stock(idx+1,buy,arr,dp);
            dp[idx][buy] = Math.max(pick,skip);
        }else{
            int pick = profit+arr[idx]+stock(idx+1,1,arr,dp);
            int skip = stock(idx+1,buy,arr,dp);
            dp[idx][buy] = Math.max(pick,skip);

        }
        return dp[idx][buy];
    }
    public int maxProfit(int[] prices) {
        int buy = 1;
        int idx = 0;
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return stock(idx,buy,prices,dp);

        
    }
}