class Solution {
    public boolean solve(int[] nums,boolean[] visited,int idx,int target,int sum,int k){

        if(sum==target){
            return solve(nums,visited,0,target,0,k-1);
        }
        if(k==1) return true;
        if(sum>target) return false;
        if(idx>=nums.length) return false;

        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (solve(nums, visited, i + 1,target, sum + nums[i], k)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%k!=0) return false;

        boolean visited[] = new boolean[n];

        return solve(nums,visited,0,sum/k,0,k);
        
    }
}