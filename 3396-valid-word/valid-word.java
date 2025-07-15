class Solution {
    public boolean isValid(String word){

        String w = word.toLowerCase();
        if(w.length()<3) return false;
        boolean v = false;
        boolean c = false;
        for(int i=0;i<w.length();i++){
            char ch = w.charAt(i);
            if(Character.isLetter(ch)){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    v = true;
                }else{
                    c = true;
                }
            }else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return v && c;
        
    }
}