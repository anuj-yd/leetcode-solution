class Solution {

    static class Edge {
        int dist;
        double weight;

        Edge(int dist, double weight) {
            this.dist = dist;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        double distance;

        Pair(int node, double distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2) {
            return Double.compare(p2.distance, this.distance); // Max heap
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double t = succProb[i];

            adj.get(u).add(new Edge(v, t));
            adj.get(v).add(new Edge(u, t));
        }

        double[] dist = new double[n];
        dist[start] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            if (u == end) return current.distance;

            for (Edge nbr : adj.get(u)) {
                int v = nbr.dist;
                double weight = nbr.weight;

                if (dist[u] * weight > dist[v]) {
                    dist[v] = dist[u] * weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return 0.0;
    }
}
