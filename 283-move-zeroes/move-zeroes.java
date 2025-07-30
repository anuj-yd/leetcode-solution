class Solution {
    // Correct swap method that modifies the array
    public void swap(int[] nums, int l, int h){
        int temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = i + 1;

        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
            if (nums[i] != 0) {
                i++;
                j = i + 1;
            }
        }
    }
}
