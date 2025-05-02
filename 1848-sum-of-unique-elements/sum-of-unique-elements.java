class Solution {
    public int sumOfUnique(int[] nums){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            boolean b=true; 
            for(int j=0;j<nums.length;j++){
                if(i!=j&&nums[i]==nums[j]){
                    b=false;
                    break;
                }
            }
            if(b){
                sum+=nums[i];
            }

        }
        return sum;
        
    }
}

