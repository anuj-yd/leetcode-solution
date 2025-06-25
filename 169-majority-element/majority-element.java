class Solution {
    public int majorityElement(int[] nums) {
        // int count = 0;
        // int j = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (count == 0) {
        //         j = nums[i];
        //     }
        //     if (nums[i] == j) {
        //         count++;
        //     }else{
        //         count--;
        //     }
        // }
        // return j;
        int n = nums.length/2;
        Arrays.sort(nums);
        return nums[n];
    }
}