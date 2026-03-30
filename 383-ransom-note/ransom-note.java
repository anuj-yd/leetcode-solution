class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int r = ransomNote.length();
        int m = magazine.length();
        if(m<r) return false;
        int[] freq = new int[26];

        for(int i=0;i<m;i++){
            char ch = magazine.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;
        }

        for(int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            int idx = ch - 'a';
            freq[idx]--;
            if(freq[idx]<0) return false;
        }
        
        return true;
        
    }
}