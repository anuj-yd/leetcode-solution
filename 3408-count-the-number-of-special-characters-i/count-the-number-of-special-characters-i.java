class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(ch>=65 && ch<=91){
                upper[ch-'A']++;
            }
            if(ch>=97 && ch<=123){
                lower[ch-'a']++;
            }
        }
        int count = 0;

        for(int i=0;i<26;i++){
            if(lower[i]>0 && upper[i]>0){
                count++;
            }
        }
        return count;


    }
}