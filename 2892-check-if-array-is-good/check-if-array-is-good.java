class Solution {
    public boolean isGood(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num,max);
        }
        int[] freq = new int[max+1];
        for(int num : nums){
            freq[num]++;
        }

        for(int i=1;i<=max-1;i++){
            if(freq[i]!=1) return false;

        }
        if(freq[max]==2) return true;
        return false;
    }
}