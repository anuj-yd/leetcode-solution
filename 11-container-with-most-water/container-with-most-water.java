class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int ma = 0;
        while(i<=j){
            int w = j-i;

            int h = Math.min(height[i],height[j]);
            int area = w*h;

            ma = Math.max(ma,area);

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return ma;
        
    }
}