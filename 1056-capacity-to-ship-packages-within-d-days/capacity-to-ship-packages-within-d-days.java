class Solution {

    public boolean isPos(int wt[],int mid,int days){
        int d = 1;
        int load = 0;

        for(int i=0;i<wt.length;i++){

            if(wt[i]+load<=mid){
                load += wt[i];
            }else{
                d++;
                load = wt[i];
            }

        }
        return d<=days;
    }
    public int shipWithinDays(int[] weights, int days) {

        int l = 0;
        int h = 0;
        for(int wt : weights){
            l = Math.max(l,wt);
            h+=wt;
        }
        int ans = -1;

        while(l<=h){
            int mid = l+(h-l)/2;

            if(isPos(weights,mid,days)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
        
    }
}