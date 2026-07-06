class Solution {
    public boolean dfs(int node,boolean[] vis,boolean[] pvis,List<List<Integer>> adj,Stack<Integer> st){
        vis[node] = true;
        pvis[node] = true;
        
        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                if(dfs(nbr,vis,pvis,adj,st)) return true;
            }else if(pvis[nbr]){
                return true;
            }
        }
        pvis[node] = false;
        st.push(node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[] = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int ed[] : prerequisites){
            int u = ed[0];
            int v = ed[1];

            adj.get(v).add(u);
        }        

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] pvis = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i] && dfs(i,vis,pvis,adj,st)){
                return new int[0];
            }
        }
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        return ans;
    }
}