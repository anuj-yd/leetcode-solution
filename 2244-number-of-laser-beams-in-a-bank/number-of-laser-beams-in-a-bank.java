import java.util.*;

class Solution {
    public int numberOfBeams(String[] bank) {

        List<Integer> ans = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < bank.length; i++) {
            String row = bank[i];
            
            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }

            if (count > 0) ans.add(count);
            count = 0;
        }

        int pro = 0;
        for (int i = 1; i < ans.size(); i++) {
            pro += ans.get(i - 1) * ans.get(i);
        }

        return pro;
    }
}
