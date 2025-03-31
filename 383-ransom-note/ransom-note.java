import java.util.Arrays;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();

        Arrays.sort(ransomArr);
        Arrays.sort(magazineArr);

        int i = 0, j = 0;
        while (i < ransomArr.length && j < magazineArr.length) {
            if (ransomArr[i] == magazineArr[j]) {
                i++; 
            }
            j++;
        }
        return i == ransomArr.length; 
    }
}
