class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            else if (nums[s] <= nums[mid]) {
                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1; // target lies in left half
                } else {
                    s = mid + 1; // target lies in right half
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[e]) {
                    s = mid + 1; // target lies in right half
                } else {
                    e = mid - 1; // target lies in left half
                }
            }
        }
        return -1;
    }
}
