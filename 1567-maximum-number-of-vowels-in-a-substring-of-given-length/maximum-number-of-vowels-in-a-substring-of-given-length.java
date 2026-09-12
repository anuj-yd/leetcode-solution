class Solution {
    public int maxVowels(String s, int k) {
        int maxV = -1;
        int i=0,j=0,n=s.length();
        int noOfV = 0;
        while(j<n){

            char chj = s.charAt(j);
            if(chj == 'a' || chj == 'e' || 
            chj == 'i' || chj == 'o' || chj == 'u'){
                noOfV++;
            }
        
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                char chi = s.charAt(i);
                maxV = Math.max(maxV,noOfV);
                if(chi == 'a' || chi == 'e' || 
                chi == 'i' || chi == 'o' || chi == 'u'){
                    noOfV--;
                }
                
                i++;
                j++;
            }
        }

        return maxV;
        
    }
}