class Solution {
    public int trailingZeroes(int n){
        if(n==0)return n;
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
