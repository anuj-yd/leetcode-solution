class Solution {
    public boolean isPos(int[] arr,int m,int k,int mid){
        
        int reqB = 0;
        int count = 0;

        for(int i=0;i<arr.length;i++){
            if(mid>=arr[i]){
                count++;

                if(count == k){
                    reqB++;
                    count=0;
                }
            }else{
                count = 0;
            }
        }



        return reqB>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        for(int day : bloomDay){
            l = Math.min(l, day);
            h = Math.max(h, day);
        }
        int ans = -1;
        while(l<=h){
            int mid = l+(h-l)/2;

            if(isPos(bloomDay,m,k,mid)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}