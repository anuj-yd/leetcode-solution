import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, visited, adj);
    }

    private boolean dfs(int curr, int dest, boolean[] visited, List<List<Integer>> adj) {
        if (curr == dest) return true;

        visited[curr] = true;

        for (int nbr : adj.get(curr)) {
            if (!visited[nbr]) {
                if (dfs(nbr, dest, visited, adj)) return true;
            }
        }
        return false;
    }
}
