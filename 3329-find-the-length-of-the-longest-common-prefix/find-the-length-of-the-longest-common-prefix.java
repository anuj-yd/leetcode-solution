class Solution {
    public int noOfDigit(int val){
        int count = 0;
        while(val!=0){
            count++;
            val/=10;
        }
        return count;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        for(int val : arr1){
            while(!hs.contains(val) && val>0){
                hs.add(val);
                val /= 10;
            }
        }
        for(int val : arr2){
            while(!hs.contains(val) && val>0){
                val/=10;
            }
            if(val>0){
                int count = noOfDigit(val);
                max = (int)Math.max(max,count);
                // max = (int)Math.max(max,(Math.log10(val)+1));
            }
            // }
        }
        return max;
    }
}