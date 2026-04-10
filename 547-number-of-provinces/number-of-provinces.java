class Solution {
    public void dfs(int i,List<List<Integer>> graph,boolean[] visited){
        visited[i] = true;
        for(int nbr : graph.get(i)){
            if(!visited[nbr]){
                dfs(nbr,graph,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int v = isConnected.length;
        for(int i=0;i<v;i++) graph.add(new ArrayList<>());
        for(int i=0;i<v;i++){
            for(int j = 0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }   
            }
        }
        boolean visited[] = new boolean[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                count++;
                dfs(i,graph,visited);
            }
        }
        return count;
    }
}