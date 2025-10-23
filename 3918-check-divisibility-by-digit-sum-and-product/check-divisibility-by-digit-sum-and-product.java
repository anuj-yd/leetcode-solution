class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int org = n;
        int n1 = n;
        int pro = 1;
        while(n!=0){
            int d = n%10;
            sum = sum + d;
            pro = pro *d;
            n = n/10;
        }
        int tot = sum+pro;
        return org % tot == 0;
        
    }
}