class Solution {
    public int singleNonDuplicate(int[] arr) {
        int l = 0;
        int h = arr.length-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(mid%2!=0){
                mid--;
            }
            
            if(arr[mid]==arr[mid+1]){
                l = mid+2;
            }else{
                h = mid;
            }

        }
        return arr[l];


        
    }
}