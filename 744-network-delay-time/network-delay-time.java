class Solution {
    class Pair{
        int vtx;
        int wt;

        Pair(int vtx,int wt){
            this.vtx = vtx;
            this.wt = wt;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph.get(u).add(new Pair(v,w));
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        dist[k] = 0;
        pq.offer(new Pair(k,0)); 

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int vtx = p.vtx;
            int wt = p.wt;
            if(wt > dist[vtx]) continue;
            for(Pair nbr : graph.get(vtx)){
                if(wt+nbr.wt<dist[nbr.vtx]){
                    dist[nbr.vtx] = wt+nbr.wt;
                    pq.offer(new Pair(nbr.vtx,wt+nbr.wt));
                }
            }
        }

        int max = 0;
        for(int i = 1; i <=n; i++) {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}