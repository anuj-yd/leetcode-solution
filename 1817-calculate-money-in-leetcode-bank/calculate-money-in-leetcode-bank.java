// class Solution {
//     public int totalMoney(int n) {
//         int mon = 1; 
//         int d = 0;   
//         int save = 0;

//         while(d < n){
//             save += mon + (d % 7); // money for the current day
//             d++;
//             if(d % 7 == 0){ 
//                 mon++;
//             }
//         }

//         return save;
//     }
// }


class Solution {
    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int remainingDays = n % 7;

        // Sum of all full weeks
        int sumWeeks = fullWeeks * 28 + 7 * fullWeeks * (fullWeeks - 1) / 2;

        // Sum of remaining days
        int sumRemaining = remainingDays * (fullWeeks + 1 + fullWeeks + remainingDays) / 2;

        return sumWeeks + sumRemaining;
    }
}
