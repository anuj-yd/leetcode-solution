class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites){

        int V = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i =0;i<V;i++) adj.add(new ArrayList<>());
        for(int pre[] : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int [] ans = new int[V];
        int idx=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++]= node;
            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        if (idx < V) return new int[0];
        return ans;
        
    }

    
}