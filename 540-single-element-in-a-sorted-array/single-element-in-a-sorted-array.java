class Solution {
    public int singleNonDuplicate(int[] nums){
        int i=0;
        int j=0;
        int n = nums.length;
        while(n>0){
            j=j^nums[i];
            i++;
            n--;
        }
        return j;
        
    }
}