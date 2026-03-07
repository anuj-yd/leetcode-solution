/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void solve(List<Integer> ans,int lvl,TreeNode root){
        if(root == null) return;
        if(ans.size()==lvl){
            ans.add(root.val);
        }else{
            ans.set(lvl,Math.max(ans.get(lvl),root.val));
        }
        if(root.left!=null) solve(ans,lvl+1,root.left);
        if(root.right!=null) solve(ans,lvl+1,root.right);

    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(ans,0,root);
        return ans;
        // if(root==null) return ans;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     int len = q.size();
        //     int max = Integer.MIN_VALUE;
        //     for(int i = 0;i<len;i++){

        //         TreeNode temp = q.poll();

        //         if(temp.val>max){
        //             max = temp.val;
        //         }
        //         if(temp.left!=null) q.offer(temp.left);
        //         if(temp.right!=null) q.offer(temp.right);

        //     } 
        //     ans.add(max);
        // }
        // return ans;
        
    }
}