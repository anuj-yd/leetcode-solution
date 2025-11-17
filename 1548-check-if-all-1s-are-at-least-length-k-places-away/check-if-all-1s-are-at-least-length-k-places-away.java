class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last = -1; // index of last seen 1, -1 if none seen yet

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (last != -1) {
                    // zeros between last and current = i - last - 1
                    if (i - last - 1 < k) return false;
                }
                last = i;
            }
        }
        return true;
    }
}
