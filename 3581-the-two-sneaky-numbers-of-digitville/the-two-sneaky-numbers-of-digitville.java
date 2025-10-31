import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                dup.add(num);
            }
        }
        int[] res = new int[dup.size()];
        int i = 0;
        for (int num : dup) {
            res[i++] = num;
        }
        return res;
    }
}
