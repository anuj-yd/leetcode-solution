class Solution {
    public int[] rearrangeArray(int[] nums){
        int ans[]=new int[nums.length];
        int pidx=0;
        int nidx=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                ans[pidx]=nums[i];
                pidx=pidx+2;
            }else{
                ans[nidx]=nums[i];
                nidx=nidx+2;
            }
        }
        return ans;
        
    }
}