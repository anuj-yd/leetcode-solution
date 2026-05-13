class Solution {

    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for(int i = 0; i < n / 2; i++){

            int a = nums[i];
            int b = nums[n - i - 1];

            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;

            int sum = a + b;

            // default 2 moves
            diff[2] += 2;

            // 1 move range start
            diff[low] -= 1;

            // 0 move at exact sum
            diff[sum] -= 1;

            // back to 1 move
            diff[sum + 1] += 1;

            // back to 2 moves
            diff[high + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;

        int moves = 0;

        for(int s = 2; s <= 2 * limit; s++){

            moves += diff[s];

            ans = Math.min(ans, moves);
        }

        return ans;
    }
}