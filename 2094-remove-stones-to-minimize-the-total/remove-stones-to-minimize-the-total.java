class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int num : piles){
            pq.offer(num);
        }

        while(k!=0){
            int val = pq.poll();
            val = val - (int)Math.floor(val/2);
            pq.offer(val);
            k--;
        }
        int sum = 0;

        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}