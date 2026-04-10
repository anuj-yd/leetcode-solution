class Solution {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0; 

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
        
    }
    public static void dfs(int node,int[][] graph,boolean[] visited){
        visited[node]=true;
        for(int j=0;j<graph.length;j++){
            if(graph[node][j]==1 && !visited[j]){
                dfs(j,graph,visited);
            }
        }

    }
}