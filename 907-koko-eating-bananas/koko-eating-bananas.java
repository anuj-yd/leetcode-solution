class Solution {
    public boolean isPos(int piles[],int h,int mid){
        long reqH = 0;

        for(int i=0;i<piles.length;i++){
            reqH += (piles[i] + mid-1)/mid;
        }

        return reqH<=h;
    }
    public int minEatingSpeed(int[] piles, int hrs) {
        int l = 1;
        int h = Integer.MIN_VALUE;

        for(int p : piles){
            h = Math.max(h,p);
        }
        int ans = -1;
        while(l<=h){
            int mid = l+(h-l)/2;

            if(isPos(piles,hrs,mid)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}