class Solution {
    public int maxDistance(int[] colors) {

        int n = colors.length;
        int max = 0;
        int i = 0;
        int j = n - 1;
        while (j > i) {
            if (colors[i] != colors[j]) {
                max = j - i;
                break;
            }
            j--;
        }
        i = 0;
        j = n - 1;
        while (i < j) {
            if (colors[i] != colors[j]) {
                max = Math.max(max, j - i);
                break;
            }
            i++;
        }

        return max;
    }
}