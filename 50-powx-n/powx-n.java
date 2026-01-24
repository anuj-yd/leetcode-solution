class Solution {
    public double myPow(double x, int n) {
        long n1 = n;
        double res = 1.0;
        if (n1 < 0) {
            x = 1 / x;
            n1 = -n1;
        }

        while(n1>0){
            if(n1%2==1) res*=x;
            x*=x;
            n1>>=1;
        }
        return res;
        
    }
}