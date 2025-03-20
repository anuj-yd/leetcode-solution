class Solution {
    public int removeDuplicates(int[] nums){
        int n = nums.length;
        int c=0;
        if(nums.length==0) return 0;
        for(int i=1;i<n;i++){
            if(nums[c]!=nums[i]){
                c++;
                nums[c]=nums[i];
            }
        }
        return c+1;
    }
}