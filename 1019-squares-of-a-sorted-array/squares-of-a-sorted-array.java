class Solution {
    public int[] sortedSquares(int[] nums){
        int ans[] = new int[nums.length];
        int i=0;
        while(i<nums.length){
            ans[i]=nums[i]*nums[i];
            i++;
        }
        Arrays.sort(ans);
        return ans;
        
    }
}