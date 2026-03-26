class Solution {
    public boolean isAnagram(String s, String t) {

        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(freq[ch - 'a'] != 0){
                freq[ch - 'a'] = freq[ch - 'a'] + 1;
            } else {
                freq[ch - 'a'] = 1;
            }
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);

            if(freq[ch - 'a'] != 0){
                freq[ch - 'a'] = freq[ch - 'a'] - 1;
            } else {
                return false;
            }
        }

        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}
// class Solution {
//     public boolean isAnagram(String s, String t) {

//         Map<Character,Integer> map = new HashMap<>();

//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
             
//             if(map.containsKey(ch)){
//                 map.put(ch,map.getOrDefault(ch,0)+1);
//             }else{
//                 map.put(ch,1);
//             }

//         }

//         for(int i=0;i<t.length();i++){
//             char ch = t.charAt(i);
//             if(map.containsKey(ch)){
//                 map.put(ch,map.getOrDefault(ch,0)-1);
//                 if(map.get(ch)==0) map.remove(ch);
//             }else{
//                 return false;
//             }
            
//         }

//         return map.size() == 0;
        
//     }
// }