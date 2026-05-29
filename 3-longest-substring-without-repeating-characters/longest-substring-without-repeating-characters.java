class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while(right<s.length()){
            char chr = s.charAt(right);
            map.put(chr,map.getOrDefault(chr,0)+1);
            while(left<=right && map.size()<right-left+1){
                char chl = s.charAt(left);
                map.put(chl,map.get(chl)-1);
                if(map.get(chl)==0) map.remove(chl);
                left++;
            }
            if(map.size()== right-left+1){
                max = Math.max(max,right-left+1);
            }
            right++;

        }
        return max==Integer.MIN_VALUE ? 0 : max;
        
    }
}