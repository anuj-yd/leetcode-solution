class Solution {
    public int dfs(List<List<Integer>> adj,int curr,int k,boolean[] vis){
         vis[curr] = true;

        if (k == 0) return 1;
        if (k < 0) return 0;

        int tn = 1;

        for (int nbr : adj.get(curr)) {
            if (!vis[nbr]) {
                tn += dfs(adj, nbr, k - 1, vis);
            }
        }

        return tn;

    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n1 = edges1.length+1;
        int n2 = edges2.length+1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for(int i=0;i<n1;i++) adj1.add(new ArrayList<>());
        for(int i=0;i<n2;i++) adj2.add(new ArrayList<>());

        for(int ed1[] : edges1){
            int u = ed1[0];
            int v = ed1[1];

            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        for(int ed2[] : edges2){
            int u = ed2[0];
            int v = ed2[1];

            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        int max2 = 0;

        for(int i=0;i<n2;i++){
            boolean visited[] = new boolean[n2];
            max2 = Math.max(max2,dfs(adj2,i,k-1,visited));
        }

        int[] ans = new int[n1];

        for (int i = 0; i < n1; i++) {
            boolean[] visited = new boolean[n1];
            ans[i] = max2 + dfs(adj1, i, k, visited);
        }

        return ans;
        
    }
}