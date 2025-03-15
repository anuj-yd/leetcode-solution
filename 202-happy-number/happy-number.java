class Solution {
    public boolean isHappy(int n) {
        int slow = n; // Slow pointer
        int fast = n; // Fast pointer

        do {
            slow = sumOfSquares(slow); // Move slow one step
            fast = sumOfSquares(sumOfSquares(fast)); // Move fast two steps
        } while (slow != fast); // Repeat until they meet

        return fast == 1;
    }

    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // Get the last digit
            sum += digit * digit; // Add the square of the digit
            num /= 10; // Remove the last digit
        }
        return sum;
    }
}