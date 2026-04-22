class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> ans = new ArrayList<>(); 
        for(String wrd : queries){
            for(String dic : dictionary){
                int count = 0;
                for(int i = 0;i<wrd.length();i++){
                    if(wrd.charAt(i)!=dic.charAt(i)){
                        count++;
                        if(count>2) break;
                    }
                }
                if(count<=2) {
                    ans.add(wrd);
                    break;
                }
            }
        }
        return ans;
        
    }
}