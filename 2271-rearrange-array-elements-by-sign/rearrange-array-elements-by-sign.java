class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];

        int ei = 0;
        int oi = 0;
        for(int val : nums){
            if(val<0) neg[oi++] = val;
            else pos[ei++] = val;
        }


        for(int i=0;i<n/2;i++){
            nums[i*2] = pos[i];
            nums[i*2+1] = neg[i];
        }

        return nums;
        
    }
}