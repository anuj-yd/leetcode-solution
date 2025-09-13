class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0, maxConsonant = 0;

        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            if (isVowel((char) (i + 'a')))
                maxVowel = Math.max(maxVowel, freq[i]);
            else
                maxConsonant = Math.max(maxConsonant, freq[i]);
        }

        return maxVowel + maxConsonant;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
