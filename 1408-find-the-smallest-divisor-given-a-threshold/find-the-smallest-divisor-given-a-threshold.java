class Solution {
    private int totalSum(int mid,int[] nums){
        int sum = 0;
        for(int n : nums){
            sum+= (n+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            if(n>max) max = n;
        }

        int low = 1;
        int high = max;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            int sum = totalSum(mid,nums);
            if(sum>threshold){
                low = mid+1;
            }else{
                ans = mid;
                high = mid-1;   
            }

        }
        return ans;
    }
}