class Solution {
    public int bestClosingTime(String customers) {
        int sum = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') sum++;
        }
        int psum = sum;
        int bsthr = 0;
        for(int i=0;i<customers.length();i++){
            char ch = customers.charAt(i);
            if(ch == 'Y'){
                sum--;
            }else if(ch=='N'){
                sum++;
                
            }
            if(sum<psum){
                psum = sum;
                bsthr = i+1;
            }
        }
        
        return bsthr;

        
    }
}