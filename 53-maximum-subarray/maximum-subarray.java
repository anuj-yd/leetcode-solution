class Solution {
    public int maxSubArray(int[] nums){
        int ms =Integer.MIN_VALUE;
        int cs=0;
        for(int i=0;i<nums.length;i++){
            cs+=nums[i];
            if(cs>ms){
                ms=cs;
            }
            if(cs<0){
                cs=0;
            }
        }
        return ms;

        
        
    }
}