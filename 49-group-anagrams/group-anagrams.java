class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sort = new String(ch);

            if(!mp.containsKey(sort)){
                mp.put(sort,new ArrayList<>());
            }
            
            mp.get(sort).add(strs[i]);
            

        }
        return new ArrayList<>(mp.values());
    


        
    }
}