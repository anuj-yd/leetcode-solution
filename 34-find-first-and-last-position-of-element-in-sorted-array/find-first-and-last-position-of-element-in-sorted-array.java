class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int fp = -1;
        int lp = -1;
        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid] == target){
                fp=lp=mid;
                while(fp>0 && nums[fp-1]==target){
                    fp = fp-1;
                }
                while(lp<nums.length-1 && nums[lp+1]==target){
                    lp = lp+1;
                }
                break;
            }else if(nums[mid]<target){
                s= mid+1;
            }else{
                e = mid-1;
            }

        }
        return new int[]{fp,lp};
        
    }
}