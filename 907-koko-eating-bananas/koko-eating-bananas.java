class Solution {
    private boolean minTime(int[] piles,int mid,int h){
        long time = 0;
        for(int n : piles){
            time+= (n+mid-1)/(long)mid;
            // time+= (long)Math.ceil(n/(double)mid);
        }
        if(time<=h) return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int n : piles){
            if(n>max) max = n;
        }
        int low = 1;
        int high = max;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(minTime(piles,mid,h)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
        
    }
}