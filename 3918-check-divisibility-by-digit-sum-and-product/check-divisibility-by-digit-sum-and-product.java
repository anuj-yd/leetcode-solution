class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int org = n;
        int n1 = n;
        while(n!=0){
            int d = n%10;
            sum = sum + d;
            n = n/10;
        }
        int pro = 1;
        while(n1!=0){
            int d1 = n1%10;
            pro = pro *d1;
            n1 = n1/10;
        }

        int tot = sum+pro;
        return org % tot == 0;
        
    }
}