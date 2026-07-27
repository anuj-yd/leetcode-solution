class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int org = x,l=1,h=x;
        while(l<=h){
            int mid = l+(h-l)/2;
            long sq = (long) mid * mid;

            if(sq==org){
                return mid;
            }else if(sq> org){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return h;
        
    }
}