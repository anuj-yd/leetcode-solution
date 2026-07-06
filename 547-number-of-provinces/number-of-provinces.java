class Solution {
    public void bfs(int node,boolean[] vis,List<List<Integer>> adj){
       
       vis[node] = true;
       Queue<Integer> q = new LinkedList<>();

       q.offer(node);
       while(!q.isEmpty()){

            int curr = q.poll();
            for(int nbr : adj.get(curr)){
                if(!vis[nbr]){
                    q.offer(nbr);
                    vis[nbr] = true;
                }
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
                bfs(i,vis,adj);
                count++;
            }
        }
        return count;
        
    }
}