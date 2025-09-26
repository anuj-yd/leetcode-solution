

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefix sum 0 has one count

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if there's a prefix sum that makes current subarray = k
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Store/update prefix sum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
