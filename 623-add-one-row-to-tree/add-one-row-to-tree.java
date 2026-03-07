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
    public void solve(TreeNode root, int val, int lvl,int depth){
        if(root == null) return;
        if(lvl == depth){
            TreeNode currlf = root.left;
            TreeNode currrh = root.right;

            TreeNode newNode1 = new TreeNode(val);
            root.left = newNode1;
            newNode1.left = currlf;

            TreeNode newNode2 = new TreeNode(val);
            root.right = newNode2;
            newNode2.right = currrh;
            return;
        }
        solve(root.left,val,lvl+1,depth);
        solve(root.right,val,lvl+1,depth);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        solve(root,val,1,depth-1);    
        return root;
    }
}