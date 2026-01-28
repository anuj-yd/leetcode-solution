class Solution {
    private long totalBananas(int[] piles,int mid){
        long total = 0;
        for(int num : piles){
            // total += (long)Math.ceil(n/(double)mid);
            long rem=num%mid;
            total+=num/mid;
            if(rem>0) total++;
        }
        return total;
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
            long total = totalBananas(piles,mid);
            if(total<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }   
        }
        return ans;
        
    }
}