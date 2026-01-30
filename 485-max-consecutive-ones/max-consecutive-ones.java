class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int right = 0;
        int left = 0;
        int maxLen = 0;

        while(right<nums.length){
            
            if(nums[right]==0){
                left = right + 1;

            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
        
    }
}