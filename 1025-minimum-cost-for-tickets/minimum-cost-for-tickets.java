class Solution {
    public int solve(int[] days,int[] costs,int idx,int[] dp){
        if(idx>=days.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int day1 = costs[0]+solve(days,costs,idx+1,dp);


        int maxday = days[idx]+7;
        int j = idx;
        while(j<days.length&&days[j]<maxday) j++;
        int day7 = costs[1]+solve(days,costs,j,dp);

        j = idx;
        maxday = days[idx]+30;
        while(j<days.length&&days[j]<maxday) j++;
        int day30 = costs[2]+solve(days,costs,j,dp);
        return dp[idx] = Math.min(day1,Math.min(day7,day30));


    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Arrays.fill(dp,-1);
        return solve(days,costs,0,dp);
        
    }
}