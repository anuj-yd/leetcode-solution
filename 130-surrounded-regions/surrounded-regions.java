class Solution {
    static class Pair{
        int nj;
        int ni;
        public Pair(int ni,int nj){
            this.ni = ni;
            this.nj = nj;
        }
    }

    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[row][col];

        // 🔥 CHANGE 1: sirf boundary 'O'
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i==0 || j==0 || i==row-1 || j==col-1) && board[i][j]=='O'){
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                    board[i][j] = '#'; // mark safe
                }
            }
        } 

        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int[] d : dir){
                int ni = p.ni+d[0];
                int nj = p.nj+d[1];

                // 🔥 CHANGE 2: boundary check pehle + mark '#'
                if(ni>=0 && nj>=0 && ni<row && nj<col 
                   && !visited[ni][nj] && board[ni][nj]=='O'){

                    q.offer(new Pair(ni,nj));
                    visited[ni][nj] = true;
                    board[ni][nj] = '#'; // safe
                }
            }
        }

        // 🔥 CHANGE 3: final conversion
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}