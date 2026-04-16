class Solution {
    static class Pair{
        int ni;
        int nj;

        public Pair(int ni,int nj){
            this.ni = ni;
            this.nj = nj;
        }
    }
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i==0||j==0||i==row-1||j==col-1)&& grid[i][j]==1){
                    
                    q.offer(new Pair(i,j));
                    visited[i][j]=true;
                    
                }
            }
        }
        int count = 0;
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            Pair p = q.poll();          
            for(int[] d : dir){
                int ni = p.ni+d[0];
                int nj = p.nj+d[1];         
                if(ni>=0&&nj>=0&&ni<row
                &&nj<col&&grid[ni][nj]==1&&!visited[ni][nj]){           
                    q.offer(new Pair(ni,nj));
                    visited[ni][nj]=true;    
                }
            }
        }

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