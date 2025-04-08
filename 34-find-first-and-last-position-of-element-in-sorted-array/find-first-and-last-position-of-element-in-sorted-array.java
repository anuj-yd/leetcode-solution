class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }
    private int findBound(int[] nums, int target, boolean isFirst) {
        int s = 0, l = nums.length - 1;
        int result = -1;
        while(s <= l) {
            int mid = s+(l-s)/2;
            if(nums[mid] == target) {
                result = mid;
                if(isFirst) {
                    l = mid - 1; 
                }else{
                    s = mid + 1; 
                }
            }else if(nums[mid] < target) {
                s = mid + 1;
            }else{
                l = mid - 1;
            }
        }
        return result;
    }
}
