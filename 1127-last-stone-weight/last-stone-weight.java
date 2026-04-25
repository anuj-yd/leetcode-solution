class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones){
            pq.offer(n);
        }
        while(pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();

            if(x!=y){
                y=y-x;
                pq.offer(y);
            }
        }
        return pq.size()==0 ? 0 : pq.poll();

    }
}