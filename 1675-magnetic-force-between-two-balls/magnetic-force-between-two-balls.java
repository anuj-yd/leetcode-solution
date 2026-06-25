class Solution {
    public boolean required(int[] arr,int mid,int m){
        int b = 1;
        int last = arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i]-last>=mid){
                b++;
                last = arr[i];
            }
        }
        return b>=m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low = 1;
        int high = position[n-1]-position[0];
        int ans = -1;
        while(low<=high){

            int mid = low+(high-low)/2;
            if(required(position,mid,m)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        return ans;
        
    }
}