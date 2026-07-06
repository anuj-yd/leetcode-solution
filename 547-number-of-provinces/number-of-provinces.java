class Solution {
    public void dfs(int node,boolean[] vis,List<List<Integer>> adj){
        vis[node] = true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                dfs(nbr,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=1;i<=isConnected.length;i++) adj.add(new ArrayList<>());

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[isConnected.length];
        int count = 0;

        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                count++;
            }
        }
        return count;
        
    }
}