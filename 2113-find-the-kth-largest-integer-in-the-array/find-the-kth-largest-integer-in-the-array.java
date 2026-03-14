import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.length() != b.length()) {
                    return b.length() - a.length();   
                }
                return b.compareTo(a);               
            }
        );

        for (String num : nums) {
            pq.offer(num);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}