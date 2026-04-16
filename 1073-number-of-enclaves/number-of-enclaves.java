class Solution {
    private void dfs(int i,int j,int grid[][],boolean visited[][]){
        int row = grid.length;
        int col = grid[0].length;
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0 || visited[i][j]) return;
        visited[i][j] = true;

        dfs(i+1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j-1,grid,visited);

    }

    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean visited[][] = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i==0||j==0||i==row-1||j==col-1)&& grid[i][j]==1){
                    dfs(i,j,grid,visited); 
                }
            }
        }
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;






        
    }
}