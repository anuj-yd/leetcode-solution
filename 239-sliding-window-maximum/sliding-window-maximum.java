class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();

        int i=0;
        int j=0;
        int idx = 0;
        while(j<nums.length){

            while(!q.isEmpty() && nums[q.peekLast()] < nums[j]){
                q.pollLast();
            }
            q.offer(j);
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){
                ans[idx++] = nums[q.peekFirst()];
                if(i==q.peekFirst()){
                    q.pollFirst();
                }
                i++;
                j++;
            }
            
        } 

        return ans;



        
    }
}