class Solution {
    private boolean day(int mid,int[] weights,int days){
        int day = 1;
        int load = weights[0];
        for(int i=1;i<weights.length;i++){
            if(load+weights[i]<=mid){
                load += weights[i];
            }else{
                day = day+1;
                load = weights[i];
            }
        }
        return day<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : weights){
            if(n>max) max = n;
            sum+=n;
        }

        int low = max;
        int high = sum;
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(day(mid,weights,days)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
        
        
    }
}