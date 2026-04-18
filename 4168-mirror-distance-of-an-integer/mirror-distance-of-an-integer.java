class Solution {
    public int mirrorDistance(int n) {
        int org = n;
        int rev = 0;
        while(n!=0){
            int d = n%10;
            rev = rev * 10 + d;
            n=n/10;
        }
        return Math.abs(org-rev);
        
    }
}