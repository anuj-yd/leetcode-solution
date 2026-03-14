class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            char[] arr = strs[i].toCharArray();
            for(char ch : arr){
                int idx = ch - 'a';
                freq[idx]++;
            }
            StringBuilder key = new StringBuilder();

            for(int j = 0; j < 26; j++){
                key.append(freq[j]).append("#");
            }
            String fKey = key.toString();

            if(!map.containsKey(fKey)){
                map.put(fKey, new ArrayList<>());
            }

            map.get(fKey).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}