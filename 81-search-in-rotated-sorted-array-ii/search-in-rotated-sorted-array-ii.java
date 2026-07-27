class Solution {
    public boolean search(int[] arr, int target) {
        int l = 0;
        int h = arr.length-1;

        while(l<=h){
            int mid = l+(h-l)/2;
            if (arr[l] == target || arr[h] == target) return true;
            if(arr[l]==arr[mid] && arr[mid] == arr[h]){
                l++;
                h--;
                continue;
            }

            if(arr[mid] == target) return true;

            if(arr[l]<=arr[mid]){

                if(arr[l]<=target && target<arr[mid]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }
            else{

                if(arr[mid]<target && target<=arr[h]){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return false;


    }
}