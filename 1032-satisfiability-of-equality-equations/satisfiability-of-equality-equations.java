class Solution {
    int prnt[] = new int[26];
    public int find(int x){
        if(prnt[x]!=x){
            prnt[x] = find(prnt[x]);
        }
        return prnt[x];
    }

    public void union(int x,int y){
        int px = find(x);
        int py = find(y);

        if(px!=py){
            prnt[px] = py;
        }
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){
            prnt[i] = i;
        }
        for(String s : equations){
            if(s.charAt(1)=='='){
                int a = s.charAt(0)-'a';
                int b = s.charAt(3)-'a';
                union(a,b);
            }
        }
        for(String s : equations){
            if(s.charAt(1)=='!'){
                int a = s.charAt(0)-'a';
                int b = s.charAt(3)-'a';
                if(find(a)==find(b)) return false;
            }
        }
        return true;


        
    }
}