class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n = pairs.length;
        int t[] = new int[n];
        Arrays.fill(t,1);
        int maxLen = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    t[i] = Math.max(t[i],t[j]+1);
                    maxLen = Math.max(t[i],maxLen);
                }
            }
        }
        return maxLen;

    }
}