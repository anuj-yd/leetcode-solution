class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=nums.length-1;i>=0;i--){
            while(nums[i]!=0){
                int d = nums[i]%10;
                ans.add(0,d);
                nums[i] = nums[i]/10;
            }
        }
        int res[] = new int[ans.size()];
        int idx = 0;
        for(int num : ans){
            res[idx++] = num;
        }
        return res;
    }
}