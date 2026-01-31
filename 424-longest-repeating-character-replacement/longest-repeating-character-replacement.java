class Solution {
    public int characterReplacement(String s, int k) {
        // Map<Character,Integer> map = new HashMap<>();
        int freq[] = new int[26];

        int left = 0;
        int right = 0;

        int maxLen = 0;
        int maxFreq = 0;

        while(right<s.length()){
            // char ch = s.charAt(right);
            // map.put(ch,map.getOrDefault(ch,0)+1);
            // maxFreq = Math.max(maxFreq, map.get(ch));
            // while((right-left+1)-maxFreq>k){
            //     char ch2 = s.charAt(left);
            //     map.put(ch2,map.get(ch2)-1);
            //     if(map.get(ch2)==0) map.remove(ch2);
            //     left = left+1;
            // }
            // maxLen=Math.max(maxLen,right-left+1);
            // right++;
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            if((right - left + 1) - maxFreq <= k) maxLen=Math.max(maxLen,right-left+1);
            right++;

        }
        return maxLen;
        
    }
}