class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            for(int j=i+1;j<intervals.length;j++){
                if(intervals[j][0]<=end){
                    end = Math.max(end,intervals[j][1]);
                    i=j;
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }

        int[][] arr = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            arr[i][0] = ans.get(i).get(0);
            arr[i][1] = ans.get(i).get(1);
        }
        return arr;


        
    }
}