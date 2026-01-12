class Solution {

    private void bfs(char[][] grid, int r, int c, int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0'; 

        while (!q.isEmpty()) {
            int[] ans = q.poll();

            for (int[] nbr : arr) {
                int a = ans[0] + nbr[0];
                int b = ans[1] + nbr[1];

                if (a >= 0 && b >= 0 &&
                    a < grid.length &&
                    b < grid[0].length &&
                    grid[a][b] == '1') {

                    q.offer(new int[]{a, b});
                    grid[a][b] = '0'; 
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int[][] arr = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, arr);
                }
            }
        }
        return count;
    }
}
