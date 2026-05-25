class Solution {
    class DSU{
        int prnt[];
        int size[];

        public DSU(int n){
            prnt = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                prnt[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(prnt[x] != x){
                prnt[x] = find(prnt[x]);
            }
            return prnt[x];
        }

        public boolean union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px==py) return false;

            if(size[px]<size[py]){
                prnt[px] = py;
                size[py]+=size[px];
            }else if(size[py]<size[px]){
                prnt[py] = px;
                size[px]+=size[py];
            }else{
                prnt[py] = px;
                size[px] += size[py];
            }
            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        DSU d = new DSU(n);
        int count = n;
        for(int[] ed : connections){
            int u = ed[0];
            int v = ed[1];

            if(d.union(u,v)) count--;
        }
        return count-1;
    }
}