class Solution {
    public int[] applyOperations(int[] nums){
        // int ans[] = new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }else{
                continue;
            }
        }

        int index = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i]; 
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
        
        return nums;
        
    }
}