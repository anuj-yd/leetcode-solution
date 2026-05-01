class Solution {
    public void solve(int tar,int i,int j,int[] nums,List<List<Integer>> ans,int f1,int f2){
        while(i<j){
            long sum = (long)(f1+f2)+(long)(nums[i]+nums[j]);
            if(sum<tar){
                i++;
            }else if(sum>tar){
                j--;
            }else{
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(f1);
                temp.add(f2);
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
                i++;
                j--;
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n<4) return ans;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                solve(target,j+1,n-1,nums,ans,nums[i],nums[j]);
            }
        }
        return ans;
        
    }
}