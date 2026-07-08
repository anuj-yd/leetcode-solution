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

            if(px==py) return;

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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        DSU d = new DSU(n);
        int count = 0;

        for(int connect[] : connections){
            int u = connect[0];
            int v = connect[1];

            if(u<v){
                if(d.find(u)==d.find(v)){
                    count++;
                }
                d.union(u,v);
            }
        }

        int comp = 0;

        for(int i=0;i<n;i++){
            if(d.find(i)==i){
                comp++;
            }
        }
        int need = comp-1;

        return count>=need ? need : -1;
        
    }
}