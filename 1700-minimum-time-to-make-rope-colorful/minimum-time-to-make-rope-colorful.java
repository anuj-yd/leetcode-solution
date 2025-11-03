class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int dp[] = new int[n];
        // int totalTime = 0;
        for(int i=1;i<neededTime.length;i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                // totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                dp[i] = dp[i-1]+Math.min(neededTime[i], neededTime[i - 1]);
                
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
                // return neededTime[i];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[n-1];
        
        
        
    }
}