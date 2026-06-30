class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int dat[] = new int[n];
        for(int book[] : bookings){
            int l = book[0]-1;
            int r = book[1]-1;

            int seats = book[2];

            dat[l]+=seats;
            if(r+1<n){
                dat[r+1]-=seats;
            }
        }

        for(int i=1;i<n;i++){
            dat[i] = dat[i]+dat[i-1];
        }
        return dat;
        
    }
}