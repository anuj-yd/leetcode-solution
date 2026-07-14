class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ls = new ArrayList<>();
        int si = intervals[0][0];
        int ei = intervals[0][1];
        int idx = 1;
        while(idx<intervals.length){
            if(intervals[idx][0]<=ei){
                ei = Math.max(ei,intervals[idx][1]);
            }else{
                ls.add(new int[]{si,ei});
                si = intervals[idx][0];
                ei = intervals[idx][1];
            }
            idx++;
        }
        ls.add(new int[]{si,ei});
        int ans[][] = new int[ls.size()][2];

        for(int i=0;i<ls.size();i++){
            ans[i][0] = ls.get(i)[0];
            ans[i][1] = ls.get(i)[1];
        }        
        return ans;
    }
}