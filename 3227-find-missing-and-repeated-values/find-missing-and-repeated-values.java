class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1]; 
        int[] result = new int[2]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (freq[i] == 2) {
                result[0] = i; // Repeated value
            } else if (freq[i] == 0) {
                result[1] = i; // Missing value
            }
        }

        return result;
    }
}