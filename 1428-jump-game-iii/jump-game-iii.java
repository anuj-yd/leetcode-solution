class Solution {
    public boolean solve(int[] arr,int idx,Boolean[] dp){
        int n = arr.length;
        if(idx<0 || idx>n-1||arr[idx]<0) return false;
        if(dp[idx]!=null) return dp[idx];
        if(arr[idx] == 0) return true;
        arr[idx] = -arr[idx];
        boolean l = solve(arr,idx-arr[idx],dp);
        boolean r = solve(arr,idx+arr[idx],dp);
        return dp[idx] = l||r;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if(arr[n-1]==0) return true;
        if(arr[start]==0) return true;
        Boolean dp[] = new Boolean[n+1];
        return solve(arr,start,dp);
    }
}