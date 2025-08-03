import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph.length - 1, graph, path, ans);
        return ans;
    }

    private void dfs(int curr, int target, int[][] graph, List<Integer> path, List<List<Integer>> ans) {
        path.add(curr);

        if (curr == target) {
            ans.add(new ArrayList<>(path)); // Make a copy before backtracking
        } else {
            for (int next : graph[curr]) {
                dfs(next, target, graph, path, ans);
            }
        }

        path.remove(path.size() - 1); // Backtrack
    }
}
