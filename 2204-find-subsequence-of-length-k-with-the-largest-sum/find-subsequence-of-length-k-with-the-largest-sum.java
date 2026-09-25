class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(nums[a]-nums[b]));

        for(int i=0;i<n;i++){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }

        boolean[] selected = new boolean[n];

        
        while(!pq.isEmpty()) {
            selected[pq.poll()] = true;
        }

        int[] ans = new int[k];
        int idx=0;

        for(int i=0;i<n;i++){
            if(selected[i] && idx!=k){
                ans[idx++] = nums[i];
            }
        }

        return ans;


        
    }
}