import java.util.*;

class Solution {
    public int sumOfUnique(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        
        for (int n : nums) {
            if (seen.contains(n)) {
                dup.add(n); // agar pehle se hai to duplicate list me daal do
            } else {
                seen.add(n); // pehli baar mila to seen me daalo
            }
        }
        
        int sum = 0;
        for (int n : seen) {
            if (!dup.contains(n)) { 
                sum += n;
            }
        }
        
        return sum;
    }
}
