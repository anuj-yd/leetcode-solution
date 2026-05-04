class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;  
    
        Deque<Integer> q = new ArrayDeque<>();

        for(int num : nums){
            if(num >= 0) q.addLast(num);
        }
        if(q.size()==0) return nums;

        while(k!=0){
            q.addLast(q.pollFirst());
            k--;
        }

        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                nums[i] = q.poll();
            }
        }
        return nums;
        
    }
}