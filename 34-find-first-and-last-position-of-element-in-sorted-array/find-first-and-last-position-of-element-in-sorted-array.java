class Solution {
    public int solve1(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int idx = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                idx = mid;
                high = mid-1;
            }else if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }  
        }
        return idx;
    }
    public int solve2(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int idx = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                idx = mid;
                
                low = mid+1;
            }else if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }  
        }
        return idx;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int first = solve1(nums,target);
        int last = solve2(nums,target);
        return new int[]{first,last};
        
    }
}