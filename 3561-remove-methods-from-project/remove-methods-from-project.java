class Solution {
    public void dfs(boolean[] vis,List<List<Integer>> adj,int node){
        if(vis[node]) return;
        vis[node] = true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                dfs(vis,adj,nbr);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int ed[] : invocations){
            adj.get(ed[0]).add(ed[1]);
        }

        boolean vis[] = new boolean[n];
        dfs(vis,adj,k);

        for(int[] ed : invocations){
            int u = ed[0];
            int v = ed[1];
            if (!vis[u] && vis[v]){
                List<Integer> ans = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }


}