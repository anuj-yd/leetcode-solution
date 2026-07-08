class Solution {
    class DSU{
        int prnt[];
        int rnk[];

        DSU(int n){
            prnt= new int[n];
            rnk = new int[n];
            for(int i=0;i<n;i++){
                prnt[i] = i;
            }
        }

        public int find(int x){
            if(x == prnt[x]) return x;
            return prnt[x] = find(prnt[x]);
        }
        public void union(int x,int y){

            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rnk[px]>rnk[py]){
                prnt[py] = px;

            }else if(rnk[py]>rnk[px]){
                prnt[px] = py;
            }else{
                prnt[px] = py;
                rnk[py]++;
            }


        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU d = new DSU(n);

        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];

            if(d.find(u)!=d.find(v)){
                d.union(u,v);
            }
        }
        if(d.find(source)==d.find(destination)) return true;

        return false;
    }
}