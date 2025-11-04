import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        // Build the first window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = xSum(freq, x);

        // Slide the window
        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in = nums[i];

            // Remove outgoing element
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            // Add incoming element
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            // Compute x-sum for current window
            ans[i - k + 1] = xSum(freq, x);
        }

        return ans;
    }

    // Helper function to compute x-sum from current frequencies
    private int xSum(Map<Integer, Integer> freq, int x) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        // Sort: higher freq first, then higher value
        list.sort((a, b) -> {
            if (!Objects.equals(a.getValue(), b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return b.getKey() - a.getKey();
        });

        int sum = 0;
        int count = 0;

        for (var e : list) {
            if (count == x) break;
            sum += e.getKey() * e.getValue();
            count++;
        }

        return sum;
    }
}
