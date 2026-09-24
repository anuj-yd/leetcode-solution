class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        int[] dat = new int[s.length()];

        for(int i=0;i<shifts.length;i++){
            
            int l = shifts[i][0];
            int r = shifts[i][1];
            int d = shifts[i][2];

            int x = 0;
            x = (d == 0) ? -1 : 1;

            dat[l] += x;
            if(r+1<s.length()) dat[r+1] -= x;
            
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<s.length();i++){
            dat[i] = dat[i-1]+dat[i];
        }

        for(int i=0;i<s.length();i++){
            int ascii = (int) s.charAt(i);
            int newascii = ascii + (dat[i]%26);

           if(newascii < 97){
            int dif = 97 - newascii;
            newascii = 122 - (dif-1);
           }else if(newascii > 122){

            int dif = newascii - 122;
            newascii = 97 + (dif-1);

           }

           sb.append((char)newascii);

        }
        return sb.toString();


        


       
        
    
        
    }
}