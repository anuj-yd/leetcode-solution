class Solution {
  public int maxFreqSum(String s) {
    int[] count = new int[26];
    int maxVowel = 0;
    int maxConsonant = 0;

    for (char c : s.toCharArray()) {
      int idx = c - 'a';
      count[idx]++;

      if (isVowel(c))
        maxVowel = Math.max(maxVowel, count[idx]);
      else
        maxConsonant = Math.max(maxConsonant, count[idx]);
    }

    return maxVowel + maxConsonant;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
