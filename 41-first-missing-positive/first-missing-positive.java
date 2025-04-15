class Solution {
    public int firstMissingPositive(int[] nums) {        
        Arrays.sort(nums);
        int target = 1;
        for (int n : nums) {
            if (n == target) {
                target++;
            } else if (n > target) {
                return target;
            }
        }
        
        return target;        
    }
}