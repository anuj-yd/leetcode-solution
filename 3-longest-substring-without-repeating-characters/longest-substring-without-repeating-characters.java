import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < s.length()){
            char chr = s.charAt(right);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
            while(left<=right && map.size()!=right-left+1){
                char chl = s.charAt(left);
                map.put(chl, map.get(chl) - 1);
                if(map.get(chl) == 0) map.remove(chl);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}