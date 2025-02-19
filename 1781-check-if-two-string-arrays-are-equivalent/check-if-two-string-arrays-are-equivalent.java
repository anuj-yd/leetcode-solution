class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb.append(word1[i]); // Append the string at index i, not charAt
        }
        
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            sb1.append(word2[i]); // Append the string at index i, not charAt
        }
        
        String str1 = sb.toString(); // Added semicolon
        String str2 = sb1.toString(); // Fixed syntax and added semicolon
        
        return str1.equals(str2); // Correct string comparison
    }
}

        // String str1 = String.join("", word1);
        // String str2 = String.join("", word2);
        
        // return str1.equals(str2);}