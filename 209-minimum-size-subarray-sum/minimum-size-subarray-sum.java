class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0,j=0,csum=0,n = nums.length,ans=0,minLen = Integer.MAX_VALUE;

        while(j<n){

            csum += nums[j];
            while(csum >= target){
                minLen = Math.min(minLen,j-i+1);
                csum -= nums[i];
                i++;
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
        
    }
}