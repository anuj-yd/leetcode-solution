class Solution {
    private int helper(int[][] dp,int[][] grid,int sr,int sc,int dr,int dc){
         // Out of bounds
        if (sr > dr || sc > dc) return 0;

        // Obstacle
        if (grid[sr][sc] == 1) return 0;

        // Reached destination
        if (sr == dr && sc == dc) return 1;

        if (dp[sr][sc] != -1) return dp[sr][sc];

        int right = helper(dp, grid, sr, sc + 1, dr, dc);
        int down = helper(dp, grid, sr + 1, sc, dr, dc);

        return dp[sr][sc] = right + down;
        

    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,grid,0,0,m-1,n-1);
        
    }
}