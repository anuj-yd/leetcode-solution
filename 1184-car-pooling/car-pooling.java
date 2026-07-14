class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dat = new int[1001];

        for(int[] arr : trips){
            
            dat[arr[1]] += arr[0];
            dat[arr[2]] -= arr[0];
        }
        int prefix = 0;
        for(int i=0;i<dat.length;i++){
            prefix += dat[i];
            if(prefix>capacity) return false;
        }
        return true;
    }
}