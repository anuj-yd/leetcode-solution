class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!map.containsKey(key)){
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(key,temp);
            }else{
                map.get(key).add(s);
            }
        }

        for(List<String> rq : map.values()){
            ans.add(rq);
        }

        return ans;
        
    }
}