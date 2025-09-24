class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length-1;
        int maxArea = 0;
        while(i<=j){
            int wid = j-i;
            int h = Math.min(height[i],height[j]);
            int area = wid * h;
            maxArea = Math.max(maxArea,area);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
        
    }
}