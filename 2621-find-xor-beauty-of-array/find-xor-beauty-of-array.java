class Solution {
    public int xorBeauty(int[] nums){
        int n=0;
        for(int i=0;i<nums.length;i++){
            n=n^nums[i];
        }
        return n;
        
    }
}