class Solution {
    public int countBattleships(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        int count = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='.'){
                    continue;
                }else if(i>0 && board[i-1][j]=='X'){
                    continue;
                }else if(j>0 && board[i][j-1]=='X'){
                    continue;
                }else{
                    count++;
                }

            }
        }
        return count;
        
    }
}