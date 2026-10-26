class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);

        String s2 = new String(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        String t2 = new String(t1);

        int i=0;
        int j=0;

        while(i<s2.length()){
            if(s2.charAt(i)!=t2.charAt(j)) return false;
            i++;
            j++;
        }

        return true;

        
    }
}