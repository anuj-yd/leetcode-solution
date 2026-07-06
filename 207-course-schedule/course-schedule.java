class Solution {
    public boolean hasCycle(int node,boolean vis[],boolean pvis[],List<List<Integer>> adj){

        vis[node] = true;
        pvis[node] = true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                if(hasCycle(nbr,vis,pvis,adj)) return true;
            }else if(pvis[nbr]){
                return true;
            }
        }
        pvis[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int ed[] : prerequisites){
            int u = ed[0];
            int v = ed[1];

            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[numCourses];
        boolean pvis[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){

            if(!vis[i] && hasCycle(i,vis,pvis,adj)) return false;
        }

        return true;


    }
}