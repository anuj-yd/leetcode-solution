class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        int leftmax = -1;
        int rightmax = -1;

        int i=0;
        int j = n-1;
        int ans = 0;

        while(i<j){
            if(height[i] <= height[j]){
                leftmax = Math.max(leftmax, height[i]);
                ans += leftmax - height[i];
                i++;
            }else{
                rightmax = Math.max(rightmax, height[j]);
                ans += rightmax - height[j];
                j--;
            }
        }

        return ans;

        
    }
}