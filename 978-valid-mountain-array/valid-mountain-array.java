class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return false;
        boolean peak = false;

        for(int i=1;i<n;i++){
            // boolean l=false;
            // boolean r=false;
            // if(arr[i-1]<arr[i]) l=true;
            // if(i+1==n || arr[i]>arr[i+1]) r=true;

            // // if(i+1<n && arr[i-1]<arr[i] && arr[i]>arr[i+1]){
            // //     if(peak) return false;
            // //     peak = true;
            // // }
            // if()
            // if(l && r){
            //     if(peak) return false;
            //     peak=true;
            // }

            if(!peak){
                if(arr[i]<=arr[i-1]) return false;
            }else{
                if(i+1<n && arr[i]<=arr[i+1]) return false;
            }
            

            boolean l=false;
            boolean r=false;
            if(arr[i-1]<arr[i]) l=true;
            if(i+1<n && arr[i]>arr[i+1]) r=true;

            if(l && r){
                // if(peak) return false;
                peak=true;
            }
            
            
        }
        return peak;

    }
}