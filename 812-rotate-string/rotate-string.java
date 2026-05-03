class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        s = s+s;
        int left = 0;
        int right = 0;
        int k = goal.length();
        while(right<s.length()){

            if(right-left+1<k){
                right++;
                continue;
            }else if(right-left+1==k){
                String str = s.substring(left,right+1);
                if(str.equals(goal)) return true;
                left++;
                right++;
            }
            // while(right-left+1>k){
            //     left++;
            // }
            // String str = s.substring(left,right+1);
            // if(str.equals(goal)) return true;
            // right++;

        }
        return false;
        
    }
}