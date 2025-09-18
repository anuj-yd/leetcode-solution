class Solution {
    public int alternatingSubarray(int[] nums) {
        int maxLen = -1;
        int currLen = 1;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            if ((currLen % 2 == 1 && diff == 1) || 
                (currLen % 2 == 0 && diff == -1)) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else if (diff == 1) {
                
                currLen = 2;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1;
            }
        }

        return maxLen;
    }
}
