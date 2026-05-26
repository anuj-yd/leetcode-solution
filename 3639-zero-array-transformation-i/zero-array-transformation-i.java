class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;
        int prefix[] = new int[n];
        for(int q[] : queries){
            int l = q[0];
            int r = q[1];

            prefix[l] += 1;
            if(r + 1 < n){
                prefix[r + 1] -= 1;
            }
        }
        int pSum = 0;
        for(int i=0;i<n;i++){
            pSum += prefix[i];
            if(pSum<nums[i]) return false;
            
        }
        return true;
        
    }
}