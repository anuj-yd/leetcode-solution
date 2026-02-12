class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int V = numCourses;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>()); 
        }
        int[] indeg = new int[V];

        for(int i=0 ;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
            indeg[u]++;
        }
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        int count = 0;
        int ans[] = new int[V];
        int idx=0;
        while(!q.isEmpty()){
            int rem = q.poll();
            ans[idx++]=rem;
            count++;
            for(int nbr : graph.get(rem)){
                indeg[nbr]--;
                if(indeg[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        if (idx < V) return new int[0];
        return ans;
        
    }
}