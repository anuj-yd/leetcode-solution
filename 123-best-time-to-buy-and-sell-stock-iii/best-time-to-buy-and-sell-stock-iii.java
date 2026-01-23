class Solution {
    private int stock(int idx,int buy,int[] arr,int dp[][][],int count){
        int profit = 0;
        int n = arr.length;
        if(idx==n) return 0;
        if(count==2) return 0;
        if(dp[idx][buy][count]!=-1) return dp[idx][buy][count];
        if(buy==1){
            int pick = profit-arr[idx]+stock(idx+1,0,arr,dp,count);
            int skip = stock(idx+1,buy,arr,dp,count);
            dp[idx][buy][count] = Math.max(pick,skip);
        }else{
            int pick = profit+arr[idx]+stock(idx+1,1,arr,dp,count+1);
            int skip = stock(idx+1,buy,arr,dp,count);
            dp[idx][buy][count] = Math.max(pick,skip);

        }
        return dp[idx][buy][count];
    }
    public int maxProfit(int[] prices) {
        int buy = 1;
        int idx = 0;
        int count = 0;
        int n = prices.length;
        int dp[][][] = new int[n][2][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){

                Arrays.fill(dp[i][j],-1);
            }
        }
        return stock(idx,buy,prices,dp,count);

        
    }
}