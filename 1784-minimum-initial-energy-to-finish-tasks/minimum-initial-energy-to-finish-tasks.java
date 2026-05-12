class Solution {
    public boolean isPossible(int mid,int[][] tasks){
        Arrays.sort(tasks,(a,b)->(Math.abs(b[1]-b[0])-Math.abs(a[1]-a[0])));
        for(int i=0;i<tasks.length;i++){
            if(tasks[i][1]<=mid){
                mid-=tasks[i][0];

            }else{
                return false;
            }
        }
        return true;

    }
    public int minimumEffort(int[][] tasks) {
        int l=0;
        int r=1000000000;
        int ans=Integer.MAX_VALUE;

        while(l<r){
            int mid=l+(r-l)/2;

            if(isPossible(mid,tasks)){
                ans=mid;
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return ans;
        
    }
}