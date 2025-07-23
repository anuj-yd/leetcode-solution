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
    public TreeNode helper(int[] inorder, int inlo,int inhi,int[] postorder,int pstlo,int psthi){
        if(inlo>inhi || pstlo>psthi) return null;
        TreeNode node = new TreeNode(postorder[psthi]);

        int i = inlo;
        while(inorder[i]!=postorder[psthi]) i++;

        int leftSize = i-inlo;
        node.left = helper(inorder, inlo, i-1, postorder, pstlo, pstlo + leftSize - 1);
        node.right = helper(inorder, i+1, inhi, postorder, pstlo + leftSize, psthi - 1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        int n = inorder.length;
        return helper(inorder,0,n-1,postorder,0,n-1);        
    }
}