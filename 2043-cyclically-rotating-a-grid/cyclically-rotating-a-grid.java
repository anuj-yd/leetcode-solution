class Solution {

    public void rotate(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {

        int r = grid.length;
        int c = grid[0].length;

        int layers = Math.min(r / 2, c / 2);

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int btm = r - 1 - layer;
            int left = layer;
            int right = c - 1 - layer;

            int rlvl = 2 * (right - left + 1);

            int t = top + 1;
            int b = btm - 1;

            int clvl = 2 * (b - t + 1);

            int arr[] = new int[rlvl + clvl];

            int idx = 0;

            // top
            for (int lf = left; lf < right; lf++) {
                arr[idx++] = grid[top][lf];
            }

            // right
            for (int tb = top; tb < btm; tb++) {
                arr[idx++] = grid[tb][right];
            }

            // bottom
            for (int rt = right; rt > left; rt--) {
                arr[idx++] = grid[btm][rt];
            }

            // left
            for (int bt = btm; bt > top; bt--) {
                arr[idx++] = grid[bt][left];
            }

            int len = arr.length;

            int rot = k % len;

            // left rotate
            rotate(arr, 0, rot - 1);
            rotate(arr, rot, len - 1);
            rotate(arr, 0, len - 1);

            idx = 0;

            // top
            for (int lf = left; lf < right; lf++) {
                grid[top][lf] = arr[idx++];
            }

            // right
            for (int tb = top; tb < btm; tb++) {
                grid[tb][right] = arr[idx++];
            }

            // bottom
            for (int rt = right; rt > left; rt--) {
                grid[btm][rt] = arr[idx++];
            }

            // left
            for (int bt = btm; bt > top; bt--) {
                grid[bt][left] = arr[idx++];
            }
        }

        return grid;
    }
}