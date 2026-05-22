class Solution {

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
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
        for(int i=idx;i<n;i++){
            swap(nums,idx,i);
            solve(nums,idx+1,ans);
            swap(nums,idx,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0,ans);
        return ans;   
    }
}