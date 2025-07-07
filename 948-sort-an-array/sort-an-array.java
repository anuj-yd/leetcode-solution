import java.util.ArrayList;

class Solution {

    public void merge(int[] arr, int s, int mid, int e) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = s;
        int j = mid + 1;

        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                ans.add(arr[i]);
                i++;
            } else {
                ans.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            ans.add(arr[i]);
            i++;
        }
        while (j <= e) {
            ans.add(arr[j]);
            j++;
        }

        for (int idx = 0; idx < ans.size(); idx++) {
            arr[s + idx] = ans.get(idx);
        }
    }

    public void mergeSort(int[] arr, int s, int e) {
        if (s < e) {
            int mid = s + (e - s) / 2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid + 1, e);
            merge(arr, s, mid, e);
        }
    }

    public int[] sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
}
