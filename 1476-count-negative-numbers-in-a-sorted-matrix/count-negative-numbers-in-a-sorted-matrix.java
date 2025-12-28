class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        int i = row - 1; 
        int j = 0;

        while (i >= 0 && j < col) {
            if (grid[i][j] < 0) {
                count += (col - j); 
                i--;                
            } else {
                j++;                
            }
        }
        return count;
    }
}
