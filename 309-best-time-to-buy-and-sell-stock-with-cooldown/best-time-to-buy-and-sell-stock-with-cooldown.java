class Solution {
    private int profit(int dp[][],int[] prices,int idx,int buy){
        int n = prices.length;
        if(idx>=n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            dp[idx][buy] = Math.max(-prices[idx]+profit(dp,prices,idx+1,0),profit(dp,prices,idx+1,1));
        }else{
            dp[idx][buy] = Math.max(prices[idx]+profit(dp,prices,idx+2,1),profit(dp,prices,idx+1,0));

        }
        return dp[idx][buy];



    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return profit(dp,prices,0,1);

        
    }
}