class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long current = (long)(nums[i] - nums[j]) * nums[k];
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        
        return max < 0 ? 0 : max; 
    }
}