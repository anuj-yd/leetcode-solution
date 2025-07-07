class Solution {
    static Random rand = new Random();

    static int partition(int[] arr, int l, int h) {
        int pivotIndex = rand.nextInt(h - l + 1) + l;
        swap(arr, pivotIndex, h);

        int pvt = arr[h];
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j] <= pvt) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, h);
        return i;
    }

    static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = partition(arr, l, h);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, h);
        }
    }

    static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}