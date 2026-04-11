class Solution {
    private void dfs(int i,int j,char[][] grid,boolean[][] visited,int[][] direction){
        int n = grid.length;
        int m = grid[0].length;
        visited[i][j] = true;
        for(int[] dir : direction){
            int ni = dir[0]+i;
            int nj = dir[1]+j;

            if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]=='1' && !visited[ni][nj]){
                dfs(ni,nj,grid,visited,direction);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,visited,direction);
                    count++;
                }
            }
        }
        return count;
    }
}