class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int ed[] : prerequisites){
            int u = ed[0];
            int v = ed[1];

            adj.get(v).add(u);
        }

        int indeg[] = new int[numCourses];
        

        for(int i=0;i<numCourses;i++){
            for(int nbr : adj.get(i)){
                indeg[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int nbr : adj.get(node)){
                indeg[nbr]--;

                if(indeg[nbr]==0){
                    q.offer(nbr);
                }    
            }
        }
        return count == numCourses;

    }
}