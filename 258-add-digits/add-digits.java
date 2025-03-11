class Solution {
    public int addDigits(int num){
        while(num>=10){
            int s=0;
            while(num>0){
                int d = num%10;
                s=s+d;
                num=num/10;
            }
            num=s;
        }
        return num; 
    }
}