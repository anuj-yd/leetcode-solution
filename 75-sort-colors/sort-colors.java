class Solution {
    public void sortColors(int[] nums) {
        int i = 0;          
        int j = nums.length - 1; 
        int k = 0;         
        while (k<=j) {
            if (nums[k] == 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
                k++;
            } else if (nums[k] == 1) {
                k++;
            } else {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }
}
