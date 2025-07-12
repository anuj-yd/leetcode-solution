import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!st.isEmpty() && nums[idx] >= st.peek()) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[idx] = st.peek();
            }

            st.push(nums[idx]);
        }

        return ans;
    }
}
