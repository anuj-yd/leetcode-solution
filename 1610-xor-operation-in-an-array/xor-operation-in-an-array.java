class Solution {
    public int xorOperation(int n, int start){
        int [] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = start+2*i;
        }
        int t=0;
        for(int i=0;i<n;i++){
            t^=nums[i];
        }
        return t;
        
    }
}