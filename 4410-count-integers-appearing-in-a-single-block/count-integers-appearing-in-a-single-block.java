import java.util.*;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> bad = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1] && seen.contains(nums[i])) {
                bad.add(nums[i]);
            }

            seen.add(nums[i]);
        }

        return seen.size() - bad.size();
    }
}