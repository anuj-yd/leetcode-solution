class Solution {
    public int dfs(int r,int c,int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        
        if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0) {
            return 0;
        }

        int area = 1;

        grid[r][c] = 0;

        int[][] dir  = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int d[] : dir){
            int nr = r+d[0];
            int nc = c+d[1];
            area += dfs(nr,nc,grid);  
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                maxArea = Math.max(maxArea,dfs(i,j,grid));
            }
        }
        return maxArea;
        
    }
}