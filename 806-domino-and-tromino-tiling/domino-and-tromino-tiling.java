class Solution {
    final static int MOD = 1000000007;
    // public int fib(int[] dp,int n){
    //     if(n==0) return 0;
    //     if(n==1) return 1;
    //     if(n==2) return 2;
    //     if(dp[n]!=-1) return dp[n];
    //     dp[n]=(int)(2L*fib(dp,n-1)+fib(dp,n-2))%MOD;
    //     return dp[n]; 
        
    // }
    public int numTilings(int n) {
        // if(n==0) return 0;
        // if(n==1) return 1;
        // if(n==2) return 2;
        // long dp[] = new long[n+1];
        // dp[0]=0;
        // dp[1]=1;
        // dp[2]=2;

        // for(int i=3;i<=n;i++){
        //     dp[i]=(2*dp[i-1]+dp[i-2])%MOD;
        // }
        // return (int)dp[n];
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
        
        
    }
}