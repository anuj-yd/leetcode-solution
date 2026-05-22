class Solution {
    public void solve(int n,int idx,int k,List<List<Integer>> ans,List<Integer> comb){
        if(k==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(idx>n) return;
        comb.add(idx);
        solve(n,idx+1,k-1,ans,comb);
        comb.remove(comb.size()-1);
        solve(n,idx+1,k,ans,comb);

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        solve(n,1,k,ans,comb);
        return ans;
    }
}