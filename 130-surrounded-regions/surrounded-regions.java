class Solution {

    public void dfs(int i, int j, char[][] board, int row, int col) {
        // boundary + valid check
        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O') {
            return;
        }

        // mark safe
        board[i][j] = '#';

        // 4 directions
        dfs(i+1, j, board, row, col);
        dfs(i-1, j, board, row, col);
        dfs(i, j+1, board, row, col);
        dfs(i, j-1, board, row, col);
    }

    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        // 🔥 Step 1: boundary se DFS start
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if((i==0 || j==0 || i==row-1 || j==col-1) && board[i][j]=='O'){
                    dfs(i, j, board, row, col);
                }
            }
        }

        // 🔥 Step 2: final conversion
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}