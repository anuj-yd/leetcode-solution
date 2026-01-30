class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int right = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            char ch = s.charAt(right);
            while(map.containsKey(ch)&&map.get(ch)>=left){
                left = map.get(ch)+1;
            }
            map.put(ch,right);
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
        
    }
}