class Solution {
    public void backtrack(int n,int open,int close,List<String> ans,StringBuilder sb ){
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            backtrack(n,open + 1, close,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sb.append(')');
            backtrack(n,open, close+1,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n,0,0,ans,sb);
        return ans;


    }
}