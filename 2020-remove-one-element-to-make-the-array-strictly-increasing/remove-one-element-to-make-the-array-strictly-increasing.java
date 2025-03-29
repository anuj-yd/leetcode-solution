// class Solution {
//     public boolean canBeIncreasing(int[] nums){
//         boolean b=false;
//         for(int i=2;i<nums.length;i++){
//             int pre = nums[i-2];
//             int nxt = nums[i-1];
//             if(pre<nums[i]&&nxt<nums[i]){
//                 b=true;
//             }
//         }
//         return b;
//     }
// }
class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int violations = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (violations == 1) {
                    return false;
                }
                violations++;
                if (i == 1 || nums[i] > nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}