class Solution {
    public boolean isAnagram(String s, String t) {
        // boolean b = false;
        // if(s.campareTo(t)==0){
        //     b=true;
        // }
        // return b;

        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency map for s
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Reduce frequency for each character in t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!mp.containsKey(ch)) {
                return false; // character t me hai par s me nahi
            }
            mp.put(ch, mp.get(ch) - 1);
            if (mp.get(ch) == 0) {
                mp.remove(ch); // unnecessary key remove
            }
        }

        // Step 4: Map should be empty if perfect match
        return mp.isEmpty();
    }
}