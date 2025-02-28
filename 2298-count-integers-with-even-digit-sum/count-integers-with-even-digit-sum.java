class Solution {
    public int countEven(int num){
        int c=0;
        for(int i=2;i<=num;i++){
            int n = i;
            int sum=0;
            while(n!=0){
                int d = n%10;
                sum = sum+d;
                n=n/10;
            }
            if(sum%2==0){
                c++;
            }
        }
        return c;
    }
}