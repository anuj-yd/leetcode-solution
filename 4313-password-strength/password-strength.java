class Solution {
    public int passwordStrength(String password) {

        boolean[] seen = new boolean[128];
        int point = 0;

        for(char ch : password.toCharArray()) {

            if(seen[ch]) continue;
            seen[ch] = true;

            if(ch >= 'a' && ch <= 'z')
                point += 1;
            else if(ch >= 'A' && ch <= 'Z')
                point += 2;
            else if(ch >= '0' && ch <= '9')
                point += 3;
            else if(ch == '!' || ch == '@' || ch == '#' || ch == '$')
                point += 5;
        }

        return point;

        
        
    }
}