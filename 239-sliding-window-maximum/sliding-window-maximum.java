class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int i = 0;
        int j=0;
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int res[] = new int[n-k+1];
        while(j<arr.length){
           while (!q.isEmpty() && arr[j]>q.getLast()){
                q.pollLast(); 
            }
            q.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){
                res[i] = q.peek();
                if (arr[i] == q.peek()) {
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}