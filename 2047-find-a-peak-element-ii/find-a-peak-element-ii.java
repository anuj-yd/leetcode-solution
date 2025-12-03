class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find max element in this column
            int maxRow = 0;
            for (int r = 0; r < rows; r++) {
                if (mat[r][mid] > mat[maxRow][mid]) {
                    maxRow = r;
                }
            }

            boolean left = (mid - 1 >= 0) && mat[maxRow][mid] < mat[maxRow][mid - 1];
            boolean right = (mid + 1 < cols) && mat[maxRow][mid] < mat[maxRow][mid + 1];

            if (!left && !right) {
                return new int[]{maxRow, mid}; 
            }

            if (right) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return new int[]{-1, -1}; 
    }
}
