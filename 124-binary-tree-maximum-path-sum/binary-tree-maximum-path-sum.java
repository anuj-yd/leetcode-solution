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
    int sum = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);
        l = Math.max(0,l);
        r = Math.max(0,r);

        sum = Math.max(sum,root.val+l+r);
        return root.val+Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return sum;
        
    }
}