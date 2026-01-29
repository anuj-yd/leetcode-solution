class Solution {
    private boolean required(int[] nums,int k,int mid){
        int reqsubarray = 1;
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            if(totalSum+nums[i]<=mid){
                totalSum+=nums[i];
            }else{
                reqsubarray++;
                totalSum=nums[i];
            }
        }
        return reqsubarray<=k;
    }
    public int splitArray(int[] nums, int k) {
        int len = nums.length;
        if(len<k) return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums){
            if(max<n) max = n;
            sum+=n;
        }

        int low = max;
        int high = sum;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(required(nums,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}