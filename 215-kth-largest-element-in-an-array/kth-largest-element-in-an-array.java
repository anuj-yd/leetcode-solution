class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
        
    }
}