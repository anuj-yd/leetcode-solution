class Solution {
    public void moveZeroes(int[] nums){
        int k = 0; 
        for (int i = 0;i < nums.length;i++) {
            if(nums[i] != 0) {
                nums[k] = nums[i];
                if(i != k) {
                    nums[i] = 0;
                }
                k++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
