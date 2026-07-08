class Solution {
    class DSU{
        int prnt[];
        int rnk[];
        DSU(int v){
            prnt = new int[v];
            rnk = new int[v];

            for(int i=0;i<v;i++){
                prnt[i] = i;
            }
        }

        public int find(int x){
            if(prnt[x] == x) return x;

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
    public int[] findRedundantConnection(int[][] edges) {
        
        DSU d = new DSU(edges.length+1);

        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];

            if(d.find(u)==d.find(v)){
                return new int[]{u,v};
            }
            d.union(u,v);
        }
        return new int[2];
    }
}