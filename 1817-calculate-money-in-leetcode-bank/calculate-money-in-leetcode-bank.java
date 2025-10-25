class Solution {
    public int totalMoney(int n) {
        int mon = 1; 
        int d = 0;   
        int save = 0;

        while(d < n){
            save += mon + (d % 7); // money for the current day
            d++;
            if(d % 7 == 0){ 
                mon++;
            }
        }

        return save;
    }
}
