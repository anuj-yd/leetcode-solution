class Solution {
    public boolean bfs(int node,int[] colors,int cc,int[][] graph){
        colors[node] = cc;
        Queue<Integer> q  = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int nd = q.poll();

            for(int nbr : graph[nd]){
                if(colors[nbr] == colors[nd]){
                    return false;
                }
                else if(colors[nbr]==-1){
                    colors[nbr] = 1-colors[nd];
                    q.offer(nbr);
                }
            }
        }
        return true;


    }
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i = 0;i<graph.length;i++){
            if(colors[i]==-1){
                if(!bfs(i,colors,0,graph)) return false;
            }
        }
        return true;
    }
}