class Solution {
    static class Pair{
        int node;
        int wt;

        Pair(int node,int wt){
            this.node=node;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int t[] : times){
            int u = t[0];
            int v = t[1];
            int wt = t[2];

            adj.get(u).add(new Pair(v,wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        int ans[] = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k] = 0;

        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int node = p.node;
            int wt = p.wt;
            if (wt > ans[node]) continue;

            for(Pair nbr : adj.get(node)){
                if(nbr.wt+wt<ans[nbr.node]){
                    ans[nbr.node] = nbr.wt+wt;
                    pq.offer(new Pair(nbr.node,ans[nbr.node]));
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(ans[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, ans[i]);
        }

        return max;
        
    }
}