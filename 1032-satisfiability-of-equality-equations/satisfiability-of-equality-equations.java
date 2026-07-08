class Solution {
    class DSU{
        int prnt[];
        int rnk[];

        DSU(int v){
            prnt = new int[v];
            rnk = new int[v];
            for(int i=0;i<v;i++){
                prnt[i]=i;
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
            if(rnk[px]>py){
                prnt[py] =  px;
            }else if(rnk[py]>px){
                prnt[px] = py;
            }else{
                prnt[px] = py;
                rnk[py]++;
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        DSU d = new DSU(26);

        for(String eq : equations){
            if(eq.charAt(1)=='='){
                int a = eq.charAt(0)-'a';
                int b = eq.charAt(3)-'a';

                d.union(a,b);
            }
        }
        for(String eq : equations){
            if(eq.charAt(1)=='!'){
                int a = eq.charAt(0)-'a';
                int b = eq.charAt(3)-'a';
                if(d.find(a)==d.find(b)) return false;
            }
        }
        return true;
        
    }
}