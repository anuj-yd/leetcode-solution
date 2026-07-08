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
            if(px == py) return;
            if(rnk[px]>rnk[py]){
                prnt[py] = px;
            }else if(rnk[py]>rnk[px]){
                prnt[px] = py;
            }else{
                prnt[py] = px;
                rnk[px]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU d = new DSU(accounts.size());

        List<List<String>> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);

                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    d.union(i,map.get(mail));
                }
            }
        }
        HashMap<Integer, TreeSet<String>> groups = new HashMap<>();

        for(String mail : map.keySet()){
            int root = d.find(map.get(mail));
            groups.putIfAbsent(root,new TreeSet<>());
            groups.get(root).add(mail);
        }

        for(int root : groups.keySet()){

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(root).get(0));
            temp.addAll(groups.get(root));
            ans.add(temp);
            
        }
        return ans;
    }
}
