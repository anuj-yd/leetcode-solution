class Solution {
    public boolean dfs(int node,int[] colors,int cc,int[][] graph){
        colors[node] = cc;

        for(int nbr : graph[node]){
            if(colors[nbr]==colors[node]){
                return false;
            }else if(colors[nbr]==-1){
                if(!dfs(nbr,colors,1-colors[node],graph)) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i = 0;i<graph.length;i++){
            if(colors[i]==-1){
                if(!dfs(i,colors,0,graph)) return false;
            }
        }
        return true;
    }
}