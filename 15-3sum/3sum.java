class Solution {
    public static void solve(int[] nums,int target,int i,int j,List<List<Integer>> ans){
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else{
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
                i++;
                j--;
            }

        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n<3) return ans;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int n1 = nums[i];
            int target = -n1;

            solve(nums,target,i+1,n-1,ans);
        }
        return ans;
    }
}