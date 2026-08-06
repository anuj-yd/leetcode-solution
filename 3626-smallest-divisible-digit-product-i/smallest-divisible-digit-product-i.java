class Solution {
    public int smallestNumber(int n, int t) {

        for(int i = n;i<=100;i++){
            int pro = 1;
            int num = i;
            while(num>0){
                int d = num%10;
                pro *= d;
                num /= 10;
            }
            if(pro>=num && pro%t==0) return i;
        }
        return -1;
       
        
    }
}