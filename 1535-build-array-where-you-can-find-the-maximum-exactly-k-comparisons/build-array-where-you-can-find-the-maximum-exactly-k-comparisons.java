class Solution {
    static final int MOD = 1_000_000_007;

    public int solve(int idx,int scost,int max,int k,int n,int m,int[][][] dp){
        if(idx==n){
            if(scost == k) return 1;
            return 0;
        }
        if(scost>k) return 0;

        if(dp[idx][scost][max+1]!=-1) return dp[idx][scost][max+1]; 
        int pick = 0;
        int skip = 0;
        for(int i=1;i<=m;i++){
            if(max<i){
                pick = (pick + solve(idx+1,scost+1,i,k,n,m,dp)) % MOD;
            }else{
                skip = (skip + solve(idx+1,scost,max,k,n,m,dp)) % MOD;
            }
        }

        return dp[idx][scost][max+1] = (pick+skip)%MOD;

        
    }
    public int numOfArrays(int n, int m, int k) {
        
        int dp[][][] = new int[51][51][102];

        for(int i=0;i<51;i++){
            for(int j=0;j<51;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0,0,-1,k,n,m,dp);
    
    }
}