// class Solution {
//     public boolean isOneBitCharacter(int[] bits) {
//         int n = bits.length;
//         int tot = 0;
//         for(int i = 0; i < n; i++){
//             tot += bits[i] * Math.pow(2, n - 1 - i);
//         }
//         int count = 0;
//         // last two bits = tot % 4
//         int last2 = tot % 4;

//         // if last two bits are 00 → one-bit character at the end
//         return last2 == 0;
//     }
// }

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        while (i < n - 1) {       // stop before last index
            if (bits[i] == 1) i += 2;
            else i += 1;
        }
        return i == n - 1;        // if we land exactly on last index, it's a one-bit char
    }
}

