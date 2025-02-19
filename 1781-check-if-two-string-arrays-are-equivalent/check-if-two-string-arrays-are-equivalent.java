class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb.append(word1[i]); 
        }
        
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            sb1.append(word2[i]); 
        }
        
        String str1 = sb.toString(); 
        String str2 = sb1.toString(); 
        
        return str1.equals(str2);     }
}
