class Solution {
    public int[] asteroidCollision(int[] astroids) {
        int n = astroids.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (st.isEmpty()) {
                st.push(astroids[i]);
            }
            else if (astroids[i] > 0) {
                st.push(astroids[i]);
            }
            else { // current asteroid is negative

                int num = Math.abs(astroids[i]);
                boolean destroyed = false;

                while (!st.isEmpty() && st.peek() > 0) {

                    if (st.peek() < num) {
                        st.pop();
                    }
                    else if (st.peek() == num) {
                        st.pop();
                        destroyed = true;
                        break;
                    }
                    else {
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) {
                    st.push(astroids[i]);
                }
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}
