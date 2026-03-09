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
    int maxSum = Integer.MIN_VALUE;
    public int sum(TreeNode root){
        if(root == null) return 0;

        int l_sum = sum(root.left);
        int r_sum = sum(root.right);
        
        l_sum = Math.max(0,l_sum);
        r_sum = Math.max(0,r_sum);

        maxSum = Math.max(maxSum,root.val+l_sum+r_sum);
        return root.val+Math.max(l_sum,r_sum);
    }
    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;

        


        
    }
}