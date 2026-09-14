class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int i=0;
        int j=0;
        int k = minutes;
        int n = customers.length;

        int csum = 0;
        for(int idx=0;idx<n;idx++){
            if(grumpy[idx]==0) csum += customers[idx];
        }

        int maxSum = csum;

        int sum = 0;
        while(j<n){
            if(grumpy[j]==1){
                sum += customers[j];
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){

                if(sum+csum > maxSum){
                    maxSum = sum+csum;
                }
                if(grumpy[i]==1){
                    sum-=customers[i];
                }
                i++;
                j++;
            }
        } 

        return maxSum;
        
    }
}