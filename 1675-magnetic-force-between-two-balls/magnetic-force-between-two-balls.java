class Solution {
    public boolean required(int[] arr,int bolls,int mid){
        int b = 1;
        int last = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=mid){
                b++;
                last = arr[i];
            }
        }
        return b>=bolls;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1]+position[0];
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(required(position,m,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}