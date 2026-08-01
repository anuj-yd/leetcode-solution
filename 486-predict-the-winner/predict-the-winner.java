class Solution {

    public int solve(int i, int j, int[] nums) {

        if(i > j){
            return 0;
        }

        int picki = nums[i] - solve(i + 1, j, nums);
        int pickj = nums[j] - solve(i, j - 1, nums);

        return Math.max(picki, pickj);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        int ans = solve(0, n - 1, nums);

        return ans >= 0;
    }
}