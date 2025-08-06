class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){

        int V = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int pre[] : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        boolean[] recVisited = new boolean[V];

        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(helper(i,visited,recVisited,adj)){
                    //  cycle detect krne false isliye return kr rhe h
                    // kyu agr cycle hui toh toh sare course process hi nhi ho payenge
                    return false;
                }
            }
        }
        return true;
        
    }

    public boolean helper(int curr,boolean[] visited,boolean[] recVisited,List<List<Integer>> adj){

        visited[curr] = true;
        recVisited[curr] = true;
        
        for(int nbr : adj.get(curr)){
            if(!visited[nbr]){
                if(helper(nbr,visited,recVisited,adj)){
                    return true;
                }
            }else if(recVisited[nbr]){
                return true;
            }
        }
        recVisited[curr] = false;
        return false;

    }
}