class Solution {
    public int findNumbers(int[] nums){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int s=0;
            int a = nums[i];
            while(a!=0){
                int d = a%10;
                s++;
                a=a/10;
                
            }
            if(s%2==0){
                count++;
            }
            
        }
        return count;
        
    }
}