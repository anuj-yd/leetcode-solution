class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxpf = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else{
                int pf=prices[i]-min;
                if(pf>maxpf){
                    maxpf=pf;
                }
            }
        }
        return maxpf;
    }
}