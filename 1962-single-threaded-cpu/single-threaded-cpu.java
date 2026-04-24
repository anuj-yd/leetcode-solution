class Solution {
    static class Pair{
        int bt;
        int idx;

        public Pair(int bt,int idx){
            this.bt = bt;
            this.idx = idx;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        for(int i=0;i<n;i++){
            int at = tasks[i][0];
            int bt = tasks[i][1];
            sortedTasks[i][0] = at;
            sortedTasks[i][1] = bt;
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks,(a,b)->a[0]-b[0]);
        int[] ans = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.bt == b.bt ? a.idx - b.idx : a.bt - b.bt
        );
        int minTime = 0;
        int idx1 = 0;
        int i = 0;
        while(idx1<n || !pq.isEmpty()){

            if(pq.isEmpty() && minTime<sortedTasks[idx1][0]){
                minTime = sortedTasks[idx1][0];
            }
            while(idx1<n && sortedTasks[idx1][0]<=minTime){
                pq.offer(new Pair(sortedTasks[idx1][1],sortedTasks[idx1][2]));
                idx1++;
            }
            Pair p = pq.poll();
            int bt = p.bt;
            int idx = p.idx;

            minTime += bt;
            ans[i++] = idx;

        }
        return ans;

        
    }
}