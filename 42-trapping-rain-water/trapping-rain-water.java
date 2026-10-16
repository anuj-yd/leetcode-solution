class Solution {
    public void solve1(int[] pge, int[] arr, int n) {
        pge[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pge[i] = Math.max(pge[i - 1], arr[i]);
        }
    }

    public void solve2(int[] nge, int[] arr, int n) {
        nge[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            nge[i] = Math.max(nge[i + 1], arr[i]);
        }
    }

    public int trap(int[] height) {
        int n = height.length;

        int[] nge = new int[n];
        int[] pge = new int[n];

        solve1(pge, height, n);
        solve2(nge, height, n);

        int area = 0;

        for (int i = 0; i < n; i++) {
            int curr = Math.min(pge[i], nge[i]) - height[i];
            area += curr;
        }

        return area;
    }
}