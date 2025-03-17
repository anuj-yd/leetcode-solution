import java.util.Arrays;

class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}