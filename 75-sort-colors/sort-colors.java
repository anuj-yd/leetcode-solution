class Solution {
    public void sortColors(int[] nums) {
        int i = 0, mid = 0, j = nums.length - 1;
        while (mid <= j) {
            if (nums[mid] == 0) {
                int temp = nums[i];
                nums[i] = nums[mid];
                nums[mid] = temp;
                i++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { 
                int temp = nums[mid];
                nums[mid] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }
    

}