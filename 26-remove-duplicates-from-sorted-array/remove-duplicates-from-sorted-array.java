class Solution {
    public int removeDuplicates(int[] nums){
        int n = nums.length;
        int j=0,i=0;
        // if(nums.length==0) return 0;
        // for(int i=0;i<n;i++){
        //     if(nums[c]!=nums[i]){
        //         c++;
        //         nums[c]=nums[i];
        //     }
        // }
        // return c+1;
        while (j < n) {
            if (nums[i] != nums[j]){
                nums[++i] = nums[j++];
            } else {
                j++;
            }

        }
        return i + 1;
    }
}