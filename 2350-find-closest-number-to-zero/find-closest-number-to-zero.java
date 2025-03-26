class Solution {
    public int findClosestNumber(int[] nums) {
        int max = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            int m = Math.abs(max);
            if (n < m || (n == m && nums[i] > max)) {
                max = nums[i];
            }
        }
        return max;
    }
}
