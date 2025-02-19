class Solution {
    public boolean isValid(String word){
        word=word.toLowerCase();
        boolean v=false;
        boolean con=false;
        if(word.length()<3) return false;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(Character.isLetter(c)){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){   
                    v=true;
                }else{
                    con=true;
                }
            }else if(!Character.isDigit(c)){
                return false;
            }
        }
        return v && con;
    }
}