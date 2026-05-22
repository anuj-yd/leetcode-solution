class Solution {
    public void solve(int[] nums,int idx,List<List<Integer>> ans,List<Integer> path){
        int n = nums.length;
        if(idx>=n){
            ans.add(new ArrayList<>(path));
            return;
        }
        //pick
        path.add(nums[idx]);
        solve(nums,idx+1,ans,path);

        //skip
        path.remove(path.size()-1);
        solve(nums,idx+1,ans,path);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        solve(nums,0,ans,path);
        return ans;  
    }
}