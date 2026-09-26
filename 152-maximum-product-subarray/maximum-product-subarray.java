class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = Integer.MIN_VALUE;
        int ppro = 1;
        int spro = 1;

        // for(int val : nums){
        //     if(ppro == 0) ppro = 1;
        //     ppro *= val; 
        //     if(ppro>maxPro) maxPro = ppro;
        // }

        // for(int i=nums.length-1;i>=0;i--){
        //     if(spro == 0) spro = 1;
        //     spro *= nums[i];
        //     if(spro>maxPro) maxPro = spro;
        // }
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            ppro *= nums[i];
            spro *= nums[n - 1 - i];

            maxPro = Math.max(maxPro, Math.max(ppro, spro));

            if (ppro == 0) ppro = 1;
            if (spro == 0) spro = 1;
        }
        return maxPro;
    }
}