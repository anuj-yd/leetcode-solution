class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;  
        Deque<Integer> q = new ArrayDeque<>();

        // collect non-negative
        for(int num : nums){
            if(num >= 0) q.addLast(num);
        }

        if(q.size() == 0) return nums;

        k = k % q.size();

        // rotate
        for(int i = 0; i < k; i++){
            q.addLast(q.pollFirst());
        }

        // put back
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                nums[i] = q.pollFirst();
            }
        }

        return nums;
    }
}