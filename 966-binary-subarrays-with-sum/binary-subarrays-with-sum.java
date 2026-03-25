class Solution {
    public int subSum(int[] nums,int k){

        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;

        while(right<n){

            sum += nums[right];

            while(left<=right && sum>k){
                sum -= nums[left];
                left++;
            }
            count += (right-left+1);
            right++;

        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {


        return subSum(nums,goal)-subSum(nums,goal-1);
        
    }
}