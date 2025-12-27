class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int trav = 0;

        while (trav <= high) {
            if (nums[trav] == 0) {
                swap(nums, trav, low);
                trav++;
                low++;
            } 
            else if (nums[trav] == 1) {
                trav++;
            } 
            else {
                swap(nums, trav, high);
                high--;
            }
        }
    }
}
