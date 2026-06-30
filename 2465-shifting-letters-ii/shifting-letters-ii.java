class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int dat[] = new int[s.length()];

        for(int sh[] : shifts){
            int l = sh[0];
            int r = sh[1];

            int x = (sh[2] == 1) ? 1 : -1;

            dat[l] += x;
            if(r+1<s.length()){
                dat[r+1]-=x;
            }
        }

        for(int i=1;i<dat.length;i++){
            dat[i] = dat[i-1]+dat[i];
        }
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            int shift = dat[i]%26;
            if(shift<0){
                shift+=26;
            }
            arr[i] = (char) (((arr[i] - 'a' + shift) % 26) + 'a');
        }
        return new String(arr);

        
        
        
    }
}