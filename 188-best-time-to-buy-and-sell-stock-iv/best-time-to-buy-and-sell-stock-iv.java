class Solution {
    private int profit(int dp[][][],int[] prices,int idx,int buy,int k){
        int n = prices.length;
        if(idx==n||k==0) return 0;
        if(dp[idx][buy][k]!=-1) return dp[idx][buy][k];
        if(buy==1){
            dp[idx][buy][k] = Math.max(-prices[idx]+profit(dp,prices,idx+1,0,k),profit(dp,prices,idx+1,1,k));
        }else{
            dp[idx][buy][k] = Math.max(prices[idx]+profit(dp,prices,idx+1,1,k-1),profit(dp,prices,idx+1,0,k));

        }
        return dp[idx][buy][k];



    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return profit(dp,prices,0,1,k);

        
    }
}