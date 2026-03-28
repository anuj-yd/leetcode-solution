class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] < 0){
                // duplicate found
                ans[0] = Math.abs(nums[i]);
            }
            else{
                nums[idx]= -nums[idx];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[1] = i+1;
            }
        }
        return ans;
        
    }
}