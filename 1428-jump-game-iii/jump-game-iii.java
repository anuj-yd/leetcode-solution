class Solution {
    public boolean solve(int[] arr,int idx){
        int n = arr.length;
        if(idx<0 || idx>n-1||arr[idx]<0) return false;
        if(arr[idx] == 0) return true;
        arr[idx] = -arr[idx];
        boolean l = solve(arr,idx-arr[idx]);
        boolean r = solve(arr,idx+arr[idx]);
        return l||r;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if(arr[n-1]==0) return true;
        if(arr[start]==0) return true;
        return solve(arr,start);
    }
}