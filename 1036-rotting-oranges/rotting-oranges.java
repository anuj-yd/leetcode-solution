class Solution {
    static class Pair{
        int ni;
        int nj;
        public Pair(int ni,int nj){
            this.ni = ni;
            this.nj = nj;
        }
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int time = 0;
        while(!q.isEmpty() && fresh>0){
            int size = q.size();

            for(int i=0;i<size;i++){
                Pair p = q.poll();

                for(int[] d : dir){
                    int ni = p.ni+d[0];
                    int nj = p.nj+d[1];

                    if(ni>=0&&nj>=0&&ni<row&&
                    nj<col&&!visited[ni][nj]&&grid[ni][nj]!=0){

                        q.offer(new Pair(ni,nj));
                        visited[ni][nj]=true;
                        fresh--;

                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}