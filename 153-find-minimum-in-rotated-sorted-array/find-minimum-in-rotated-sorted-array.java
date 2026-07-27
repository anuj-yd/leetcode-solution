class Solution {
    public int findMin(int[] arr) {
        
        int l = 0;
        int h = arr.length-1;
        int ans = Integer.MAX_VALUE;

        while(l<=h){
            int mid = l+(h-l)/2;

            if(arr[l]<=arr[mid]){
                ans = Math.min(arr[l],ans);
                l = mid+1;
            }else{
                ans = Math.min(arr[mid],ans);
                h = mid-1;
            }
        }
        return ans;
        
    }
}