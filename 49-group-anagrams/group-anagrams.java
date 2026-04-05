class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int ans[] = new int[26];
            for(char ch : s.toCharArray()){
                int idx = ch - 'a';
                ans[idx]++;
            } 
            StringBuilder key = new StringBuilder();
            for(int i=0;i<26;i++){
                key.append(ans[i]).append("#");
            }
            String fkey = key.toString();
            if(!map.containsKey(fkey)){
                map.put(fkey,new ArrayList<String>());
            }
            map.get(fkey).add(s);
        }
        return new ArrayList<>(map.values());
        
        
    }
}