class Solution {
    public int mySqrt(int n) {
        if (n == 0 || n == 1) return n;
        int l=1;
        int h=n;
        int ans = -1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if((long)mid*mid==n){
                return mid;
            }else if((long)mid*mid<n){
                ans = mid;
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans;
    }
}