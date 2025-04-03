class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        long max = 0;
        int max_i_minus_j = nums[0] - nums[1]; // tracks max (nums[i] - nums[j])
        int max_i = nums[0];                   // tracks max nums[i]
        int max_k = nums[2];                   // tracks max nums[k]
        
        // Precompute max_k values from each position to the right
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        for (int k = n-2; k >= 0; k--) {
            rightMax[k] = Math.max(nums[k], rightMax[k+1]);
        }
        
        for (int j = 1; j < n - 1; j++) {
            // Update max_i_minus_j with the best (nums[i] - nums[j]) so far
            max_i_minus_j = Math.max(max_i_minus_j, max_i - nums[j]);
            
            // Current triplet value using rightMax[j+1] as nums[k]
            long current = (long) max_i_minus_j * rightMax[j+1];
            max = Math.max(max, current);
            
            // Update max_i for next iterations
            max_i = Math.max(max_i, nums[j]);
        }
        
        return max < 0 ? 0 : max;
    }
}