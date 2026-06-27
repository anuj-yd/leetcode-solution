class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int n = s.length();
        int len = 0;

        while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(left<right && (right-left+1)>map.size()){
                char ch1 = s.charAt(left);
                map.put(ch1,map.get(ch1)-1);

                if(map.get(ch1)==0){
                    map.remove(ch1);
                }
                left++;
            }
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;

        
    }
}