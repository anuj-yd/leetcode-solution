class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int k = s1.length();
        int n = s2.length(),i=0,j=0;

        Map<Character,Integer> map = new HashMap<>();

        for(char ch : s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int count = map.size();

        while(j<n){

            char chj = s2.charAt(j);

            if(map.containsKey(chj)){
                // if(map.get(chj)>0){
                // }
                map.put(chj,map.get(chj)-1);
                if(map.get(chj)==0) count--;
                
            }

            if(j-i+1<k){
                j++;
            }

            else if(j-i+1==k){
                if(count == 0) return true;
                char chi = s2.charAt(i);

                if(map.containsKey(chi)){
                    if(map.get(chi)==0){
                        count++;
                    }
                    map.put(chi,map.get(chi)+1);
                }
                i++;
                j++;
            }
        }

        return false;


        
    }
}