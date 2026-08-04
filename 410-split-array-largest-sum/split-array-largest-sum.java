class Solution {
    public boolean isPos(int mid,int[] arr,int k){
        int reqK = 1;
        int reqSum = arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]+reqSum<=mid){
                reqSum += arr[i];
            }else{
                reqSum = arr[i];
                reqK++;
            }
        }
        return reqK<=k;
    }
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;

        for(int val : nums){
            l = Math.max(val,l);
            h += val;
        }
        int ans = -1;
        while(l<=h){
            int mid = l+(h-l)/2;

            if(isPos(mid,nums,k)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
        
    }
}