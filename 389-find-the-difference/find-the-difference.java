class Solution {
    public char findTheDifference(String s, String t){
        // convert the both string to char array
        char []cs=s.toCharArray();
        char []ct = t.toCharArray();
        // sort them to make them in ordered char array
        Arrays.sort(cs);
        Arrays.sort(ct);
        // use mismatch fuction with return the
        //  index of char that is not matching  
        int r = Arrays.mismatch(cs,ct);
        return ct[r];
    }
}