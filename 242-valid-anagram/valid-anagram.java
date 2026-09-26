class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        int[] freq = new int[26];

        int count = s.length();

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }


        for(char ch : t.toCharArray()){
            if(freq[ch-'a']>0){
                freq[ch-'a']--;
                count--;
            }
        }

        return count==0;
        
    }
}