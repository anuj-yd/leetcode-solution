class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();

        st.push(0);

        for (int num : nums) {

            while (!st.isEmpty() && st.peek() > num) {
                st.pop();
            }

            if (st.isEmpty() || st.peek() < num) {
                st.push(num);
                ans++;
            }
        }

        return ans;
    }
}