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
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; 

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; 

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
// class Solution {
//     public int findH(TreeNode root){
//         if(root == null) return 0;
//         return 1 + Math.max(findH(root.left),findH(root.right));
//     }
    
//     public boolean isBalanced(TreeNode root) {
//         if(root==null) return true;

//         int lh = findH(root.left);
//         int rh = findH(root.right);
//         if(Math.abs(rh-lh)>1) return false; 
//         boolean lh1 = isBalanced(root.left);
//         boolean rh1 = isBalanced(root.right);
//         return lh1 && rh1;
//     }
// }