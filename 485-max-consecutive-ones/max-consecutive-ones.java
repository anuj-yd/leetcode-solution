class Solution {
    public int findMaxConsecutiveOnes(int[] nums){
        int c=0;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                c++;
                cur=Math.max(c,cur);
            }else{
                c=0;
            }
        }
        return cur;
        
    }
}