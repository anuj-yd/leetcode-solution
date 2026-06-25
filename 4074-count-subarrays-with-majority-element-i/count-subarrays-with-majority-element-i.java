class Solution {

    public boolean isMajor(int[] prefix, int l, int r) {
        int freq = prefix[r + 1] - prefix[l];
        return freq > (r - l + 1) / 2;
    }

    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // prefix[i] = count of target in nums[0...i-1]
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i];
            if (nums[i] == target) {
                prefix[i + 1]++;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isMajor(prefix, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }
}