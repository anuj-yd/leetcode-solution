class Solution {
    public boolean required(int day,int[] bloomDay,int m,int k){
        int count = 0;
        int bouq = 0;
        for(int n : bloomDay){
            if(n<=day){
                count++;
            }else{
                bouq += (count/k);
                count = 0;
            }
        }
        bouq += (count/k);
        if(bouq>=m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long)m*k;
        if(val>n) return -1; 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]>max) max = bloomDay[i];
            if(bloomDay[i]<min) min = bloomDay[i];
        }

        int low = min;
        int high = max;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            boolean req = required(mid,bloomDay,m,k);
            if(req){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return ans;
        
    }
}