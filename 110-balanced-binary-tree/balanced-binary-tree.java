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
    private int check(TreeNode root){
        if(root==null) return 0;
        int lh = check(root.left);
        int rh = check(root.right);
        return 1 + Math.max(lh, rh);  // Return height, not difference
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        // Check if current node is balanced
        if(Math.abs(check(root.left) - check(root.right)) > 1) 
            return false;  // Unbalanced, return false
        
        // Check if left and right subtrees are also balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }
}