class Solution {
    
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(k+1);
        for(int num : arr){
            p.add(num);
            if(p.size()>k){
                p.poll();
            }
        }
        return p.peek(); 
    }
}
