class Solution {
    static class Edge{
        int dist;
        int weight;

        Edge(int dist,int weight){
            this.dist = dist;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair>{

        int node;
        int distance;

        Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair p2){

            return this.distance - p2.distance;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Edge>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int ed[] : times){
            int u = ed[0];
            int v = ed[1];
            int t = ed[2];

            adj.get(u).add(new Edge(v,t));
        }

        int [] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;

            for(Edge nbr : adj.get(u)){
                int v = nbr.dist;
                int weight = nbr.weight;

                if(dist[u]+weight<dist[v]){
                    dist[v] = dist[u]+weight;
                    pq.add(new Pair(v,dist[v]));
                }
            } 
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}