class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // build histogram
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            // largest rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : arr[i];

            while (!st.isEmpty() && curr < arr[st.peek()]) {
                int h = arr[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                int width = right - left - 1;
                max = Math.max(max, h * width);
            }
            st.push(i);
        }
        return max;
    }
}