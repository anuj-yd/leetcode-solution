class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dat = new int[1001];

        for(int[] arr : trips){
            int ps = arr[0];
            int s = arr[1];
            int e = arr[2];

            dat[s] += ps;
            dat[e] -= ps;
        }
        int prefix = 0;
        for(int i=0;i<dat.length;i++){
            prefix += dat[i];
            if(prefix>capacity) return false;
        }
        return true;
    }
}