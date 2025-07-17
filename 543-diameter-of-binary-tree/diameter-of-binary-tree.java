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
    public int height(TreeNode root){
        if(root == null || root.left == null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null || root.left == null && root.right==null) return 0;

        int leftroot = diameterOfBinaryTree(root.left);
        int rightroot = diameterOfBinaryTree(root.right);

        int mid = height(root.left)+height(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null) mid++;

        return Math.max(leftroot,Math.max(rightroot,mid));

    }
}