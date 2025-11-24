class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n =nums.length;
        List<Boolean> ans = new ArrayList<>();

        int dec = 0;
        for(int i = 0;i<n;i++){
            dec = (dec * 2 + nums[i]) % 5;  
            ans.add(dec == 0); 
        }
        return ans;
        
    }
}