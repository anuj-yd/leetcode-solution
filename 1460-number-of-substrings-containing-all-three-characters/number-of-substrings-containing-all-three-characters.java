class Solution {
    private int atMost(String s,int k){
        int left = 0;
        int right = 0;

        int count = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(right<s.length()){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()>k){
                char ch2 = s.charAt(left);
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2)==0) map.remove(ch2);
                left++;
            }
            count += right - left+1; 
            right++;
        }
        return count;
    }
    public int numberOfSubstrings(String s) {
        return atMost(s,3)-atMost(s,2);
        
        
    }
}