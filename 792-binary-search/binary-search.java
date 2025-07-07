class Solution {
    public int search(int[] arr, int target){
        int i=0;
        int j=arr.length-1;
        // if(j==1) return arr[0];
        int idx = 0;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return -1;
        
    }
}