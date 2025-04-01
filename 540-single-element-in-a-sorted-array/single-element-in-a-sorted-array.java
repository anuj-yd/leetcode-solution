class Solution {
    public int singleNonDuplicate(int[] nums){
        int j=0;
        for(int i:nums){
            j = j ^ i;
        }
        return j;
        
    }
}