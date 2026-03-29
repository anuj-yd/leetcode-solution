class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        Set<Character> hs = new HashSet<>();

        int r = 0,l = 0,maxLen = Integer.MIN_VALUE;

        while(r<s.length()){
            while(hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen==Integer.MIN_VALUE?-1:maxLen;
        
    }
}