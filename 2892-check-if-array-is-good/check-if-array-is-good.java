class Solution {
    public boolean isGood(int[] nums) {
        int size = nums.length;
        int n=size-1;
        int freq[] = new int[n+1];
        for(int num : nums){
            if(num>n) return false;
            freq[num]++;
        }
        for(int i = 1;i<=n-1;i++){
            if(freq[i]!=1){
                return false;
            }
        }
        if(freq[n]==2) return true;
        return false;
        
    }
}