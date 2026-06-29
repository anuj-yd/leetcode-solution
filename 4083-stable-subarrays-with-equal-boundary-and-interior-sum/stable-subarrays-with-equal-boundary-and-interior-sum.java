class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        if (n < 3) return 0;

        long[] pre = new long[n];
        pre[0] = capacity[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + capacity[i];
        }

        long ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int r = 2; r < n; r++) {

            int l = r - 2;

            StringBuilder sb1 = new StringBuilder();
            sb1.append(capacity[l]).append('#').append(pre[l] + capacity[l]);
            String addKey = sb1.toString();

            map.put(addKey, map.getOrDefault(addKey, 0) + 1);

            StringBuilder sb2 = new StringBuilder();
            sb2.append(capacity[r]).append('#').append(pre[r - 1]);
            String queryKey = sb2.toString();

            ans += map.getOrDefault(queryKey, 0);
        }

        return ans;
    }
}