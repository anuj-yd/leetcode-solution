class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int sIdx = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        int left = 0;
        int right = 0;


        while(right<s.length()){
            char rchar = s.charAt(right);
            if(map.containsKey(rchar)){
                if(map.get(rchar)>0){
                    count++;
                }
                map.put(rchar,map.get(rchar)-1);
            }

            while(count==t.length()){
                char lchar = s.charAt(left);
                if(map.containsKey(lchar)){
                    map.put(lchar,map.get(lchar)+1);
                    if(map.get(lchar)>0){
                        count--;
                    }
                }
                
                if(right-left+1<minLen) {
                    minLen=right-left+1;
                    sIdx = left;
                }
                left++;
            }
            right++;

        }
        if(sIdx==-1) return "";
        return s.substring(sIdx,sIdx+minLen);
    }
}
