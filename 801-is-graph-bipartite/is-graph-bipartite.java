class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i]!=-1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 0;

            while(!q.isEmpty()){
                int node = q.poll();
                for(int nbr : graph[node]){
                    if(color[nbr]==-1){
                        color[nbr] = 1-color[node];
                        q.offer(nbr);
                    }else if(color[nbr]==color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}