class Solution {
    public int smallestNumber(int n) {
        int count = 0;
        while(n!=1){
            n = n/2;
            count++;

        }
        int sum = 0;
        while(count!=0){
            sum+=(int)Math.pow(2,count);
            count--;
        }

        return sum+1;



        
        
    }
}