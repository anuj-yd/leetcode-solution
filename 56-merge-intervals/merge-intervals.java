class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> temp = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
    
            int v1 = end;
            int v2 = intervals[i][0];

            if(v1>=v2){
                end = Math.max(end,intervals[i][1]);
            }else{

                temp.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }


        
        }
        temp.add(new int[]{start,end});

        int[][] ans = new int[temp.size()][2];

        for(int i=0;i<temp.size();i++){
            
            ans[i] = temp.get(i);
            
        }
        return ans;

        
    }
}