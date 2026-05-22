class Solution {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void solve(int[] nums,int idx, List<List<Integer>> ans){
        int n = nums.length;
        if(idx==n){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums){
                perm.add(num);
            }
            ans.add(perm);
            return;
        }
        Set<Integer> hs = new HashSet<>();
        for(int i=idx;i<n;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
                swap(nums,i,idx);
                solve(nums,idx+1,ans);
                swap(nums,i,idx);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0,ans);
        return ans;
        
    }
}