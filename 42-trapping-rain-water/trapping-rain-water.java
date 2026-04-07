class Solution {
    public int[] findL(int[] height, int n){
        int lmax[] = new int[n]; 
        lmax[0] = height[0];

        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        return lmax;
    }

    public int[] findR(int[] height, int n){
        int rmax[] = new int[n]; 
        rmax[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; i--){
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        return rmax;
    }
    
    public int trap(int[] height) {
        int n = height.length;

        int lmax[] = findL(height, n);
        int rmax[] = findR(height, n);

        int sum = 0;

        for(int i = 0; i < n; i++){
            int h = Math.min(lmax[i], rmax[i]) - height[i];
            sum += h;
        }

        return sum;
    }
}