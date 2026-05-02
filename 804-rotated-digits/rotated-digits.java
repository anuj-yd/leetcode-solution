class Solution {

    public boolean isValid(int x){
        boolean changed = false;

        while(x!=0){
            int d = x%10;
            x = x/10;

            if(d==3||d==7||d==4) return false;

            if(d==2||d==5||d==6||d==9){
                changed = true;
            }
        }
        return changed;
    }
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            if(isValid(i)){
                count++;
            }
        }
        return count;
        
    }
}