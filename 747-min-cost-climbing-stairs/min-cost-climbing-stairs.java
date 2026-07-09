class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int j1 = cost[0];
        int j2 = cost[1];
        for(int i=2;i<cost.length;i++){
            int temp = cost[i] + Math.min(j1,j2);
            j1 = j2;
            j2 = temp;
        }        
        return Math.min(j1,j2);
    }
}