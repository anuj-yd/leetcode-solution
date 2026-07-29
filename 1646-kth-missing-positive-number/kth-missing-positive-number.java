class Solution {
    public int findKthPositive(int[] arr, int k) {

        for(int val : arr){
            if(val<=k) k++;
            else break;
        }
        return k;        
    }
}