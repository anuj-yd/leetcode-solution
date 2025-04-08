class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }

        // Include the current element in the subset
        int include = dfs(nums, index + 1, currentXor ^ nums[index]);

        // Exclude the current element from the subset
        int exclude = dfs(nums, index + 1, currentXor);

        // Return the sum of both possibilities
        return include + exclude;
    }
}
