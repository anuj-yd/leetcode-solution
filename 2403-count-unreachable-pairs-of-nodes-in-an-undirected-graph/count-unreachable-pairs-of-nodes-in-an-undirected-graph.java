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
            if(x==prnt[x]) return x;

            return prnt[x] = find(prnt[x]);
        }

        public void union(int x,int y){
            int px = find(x);
            int py = find(y);

            if(px==py) return;

            if(rnk[px]>rnk[py]){
                prnt[py] = px;
            }else if(rnk[py]>rnk[px]){
                prnt[px]=py;
            }else{
                prnt[px] = py;
                rnk[py]++;
            }
        }
    }
    public long countPairs(int n, int[][] edges) {


        DSU d = new DSU(n);

        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            if(d.find(u)!=d.find(v)){
                d.union(u,v);
            }
        }

        HashMap<Integer,Long> map = new HashMap<>();
        for(int i=0;i<n;i++){

            int leader = d.find(i);
            map.put(leader,map.getOrDefault(leader,0L)+1);
            
        }

        int rem = n;
        long res = 0;

        for(long size : map.values()){
            res += size * (rem-size);
            rem -= size;
        }
        
        return res;
        
    }
}