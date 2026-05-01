class Solution {
    public int solve(int tar,int fst,int i,int j,int[] nums,int close){
        while(i<j){
            int sum = fst+nums[i]+nums[j];
            if(Math.abs(sum - tar) < Math.abs(close - tar)){
                close = sum;
            }
            if(sum<tar){
                i++;
            }else if(sum>tar){
                j--;
            }else{
                return tar;
            }
        }
        return close;
    }
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        int close = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            close = solve(target,nums[i],i+1,n-1,nums,close);
        }
        return close;

        
    }
}