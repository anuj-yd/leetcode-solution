class Solution {
    private void dfs(int i,int j,int[][] image,boolean[][] visited,int[][] direction,int color,int oldclr){
        int n = image.length;
        int m = image[0].length;
        visited[i][j] = true;
        image[i][j] = color;
        for(int dir[] : direction){
            int ni = dir[0]+i;
            int nj = dir[1]+j;
            if(ni>=0&&nj>=0&&ni<n&&nj<m&&image[ni][nj]==oldclr && !visited[ni][nj]){
                dfs(ni,nj,image,visited,direction,color,oldclr);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int oldclr = image[sr][sc];
        if(oldclr == color) return image;

        int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        dfs(sr,sc,image,visited,direction,color,oldclr);
        return image;
        
    }
}