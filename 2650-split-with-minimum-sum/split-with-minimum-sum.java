import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        
        Arrays.sort(digits);
        
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1.append(digits[i]); 
            } else {
                num2.append(digits[i]); 
            }
        }
        
        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }
}