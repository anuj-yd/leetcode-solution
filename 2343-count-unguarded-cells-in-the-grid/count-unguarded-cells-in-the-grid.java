class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // mark guards as 1
        for (int[] g : guards)
            grid[g[0]][g[1]] = 1;
        
        // mark walls as 2
        for (int[] w : walls)
            grid[w[0]][w[1]] = 2;
        
        // directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        // mark guarded cells
        for (int[] g : guards) {
            for (int[] d : dirs) {
                int x = g[0] + d[0];
                int y = g[1] + d[1];
                
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 1 && grid[x][y] != 2) {
                    // mark as guarded if not already
                    if (grid[x][y] == 0)
                        grid[x][y] = 3;
                    x += d[0];
                    y += d[1];
                }
            }
        }
        
        // count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }
        
        return count;
    }
}
