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
    private int rightH(TreeNode root){
        int count = 0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
        
    }
    private int leftH(TreeNode root){
        int count = 0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;

    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = leftH(root);
        int rh = rightH(root);

        if(lh==rh) return (2<<(lh))-1;
        return 1+countNodes(root.left)+countNodes(root.right);

    }
}