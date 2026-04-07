class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int n = s.length();
        int count = 0;
        while(right<n){
            char chr = s.charAt(right); 
            map.put(chr,map.getOrDefault(chr,0)+1);
            

            while(left<=right && map.size()!=right-left+1){
                char chl = s.charAt(left);
                map.put(chl,map.getOrDefault(chl,0)-1);
                if(map.get(chl)==0) map.remove(chl);
                left++;
            }

            count = Math.max(count,right-left+1);
            right++;

        }
        return count;
        
    }
}