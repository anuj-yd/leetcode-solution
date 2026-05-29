class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;
        int[] res = new int[n - k + 1];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int i = 0, j = 0, idx = 0;

        while (j < n) {

            pq.offer(new int[]{arr[j], j});

            if (j - i + 1 < k) {
                j++;
            }
            else {

                // stale elements remove
                while (!pq.isEmpty() && pq.peek()[1] < i) {
                    pq.poll();
                }

                res[idx++] = pq.peek()[0];

                i++;
                j++;
            }
        }

        return res;
    }
}