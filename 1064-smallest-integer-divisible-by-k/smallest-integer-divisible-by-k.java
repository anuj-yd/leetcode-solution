class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k == 1) return 1;
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int rem = 1 % k;   
        int count = 1;     
        while (rem != 0 && count < k) {
            rem = (rem * 10 + 1) % k;
            count++;
        }

        return (rem == 0) ? count : -1;
    }
}
