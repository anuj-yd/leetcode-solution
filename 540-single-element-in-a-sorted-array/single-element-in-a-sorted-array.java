class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int val : nums) xor^=val;
        return xor;
        
    }
}