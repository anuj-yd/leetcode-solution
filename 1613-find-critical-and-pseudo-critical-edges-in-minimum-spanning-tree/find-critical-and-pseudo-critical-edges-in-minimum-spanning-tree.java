class Solution {
    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return false;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            return true;
        }
    }

    private int krushkal_Algo(List<int[]> edges, int n, int exclude, int include) {

        DSU dsu = new DSU(n);
        int cost = 0;
        int count = 0;
        if (include != -1) {
            int[] e = edges.get(include);
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
                count++;
            }
        }
        for (int i = 0; i < edges.size(); i++) {
            if (i == exclude) continue;
            int[] e = edges.get(i);
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
                count++;
            }
        }
        if (count == n - 1) return cost;
        return Integer.MAX_VALUE;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        List<int[]> sortedEdges = new ArrayList<>();
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            sortedEdges.add(new int[]{u,v,w,i});
        }
        Collections.sort(sortedEdges,(a,b)->a[2]-b[2]);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> critical = new ArrayList<>(); // hatane se weight zyada
        List<Integer> pseudo = new ArrayList<>();
        int baseCost = krushkal_Algo(sortedEdges,n,-1,-1);
        for(int i=0;i<m;i++){
            int costWithouti=krushkal_Algo(sortedEdges,n,i,-1);
            if(costWithouti>baseCost){
                critical.add(sortedEdges.get(i)[3]);
            }else{
                int costWithi = krushkal_Algo(sortedEdges,n,-1,i);
                if(costWithi == baseCost){
                    pseudo.add(sortedEdges.get(i)[3]);
                }
            }
        }
        ans.add(critical);
        ans.add(pseudo);

        return ans;
    }
}