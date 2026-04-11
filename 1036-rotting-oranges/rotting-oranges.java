class Solution {
    static class Pair{
        int ni;
        int nj;
        public Pair(int ni,int nj){
            this.ni=ni;
            this.nj = nj;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        } 
        int time = 0;
        while(!q.isEmpty() && fresh>0){
            int size = q.size();

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                for(int[] d : dir){
                    int ni = d[0]+p.ni;
                    int nj = d[1]+p.nj;

                    if(ni>=0&&nj>=0&&nj<m&&ni<n&&grid[ni][nj]==1){
                        grid[ni][nj] = 2;
                        fresh--;
                        q.offer(new Pair(ni,nj));
                    }
                }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}