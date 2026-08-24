class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for(char ch : p.toCharArray()){
            freq[ch-'a']++;
        }   
        int i = 0,j = 0,n = p.length(),count = n;
        List<Integer> ans = new ArrayList<>();
        while(j<s.length()){
            char ch = s.charAt(j);

            if(freq[ch-'a']>0) count--;
            freq[ch-'a']--;

            while(j-i+1>n){
                char chl = s.charAt(i);

                if(freq[chl-'a'] >= 0){
                    count++;
                }
                freq[chl-'a']++;
                i++;
            }

            if(j-i+1==n && count == 0) ans.add(i);
            j++;
        }

        return ans;
        
    }
}