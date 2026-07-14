class Solution {
    public boolean solve(int idx,int jump,int n,int[] stones,Map<Integer,Integer> map,Boolean[][] dp){

        if(idx==n-1) return true;
        if(dp[idx][jump]!=null) return dp[idx][jump];
        boolean canR = false;
        if(jump-1>0) {
            int nextPos = stones[idx] + (jump - 1);
            if(map.containsKey(nextPos)) {
                int newIdx = map.get(nextPos);
                canR |= solve(newIdx, jump - 1, n, stones, map,dp);
            }
        }
        if(jump>0) {
            int nextPos = stones[idx] + jump;
            if(map.containsKey(nextPos)) {
                int newIdx = map.get(nextPos);
                canR |= solve(newIdx, jump, n, stones, map,dp);
            }
        }
        if(jump+1<n) {
            int nextPos = stones[idx] + (jump + 1);
            if(map.containsKey(nextPos)) {
                int newIdx = map.get(nextPos);
                canR |= solve(newIdx, jump+1, n, stones, map,dp);
            }
        }
        return dp[idx][jump] = canR;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1]!=1) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        Boolean dp[][] = new Boolean[n][n+1];

        return solve(1,1,n,stones,map,dp);
    }
}