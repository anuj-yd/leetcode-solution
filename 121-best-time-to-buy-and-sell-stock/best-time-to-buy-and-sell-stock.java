class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int buy = prices[0];

        for(int i = 1;i<prices.length;i++){
            if(buy<prices[i]){
                profit = prices[i]-buy;
                maxProfit = Math.max(maxProfit,profit);

            }else{
                buy=prices[i];

            }
            
            // if(prices[i]<buy){
            //     buy=prices[i];
            // }
        }
        return maxProfit;

        
    }
}