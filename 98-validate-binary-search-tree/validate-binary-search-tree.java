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
    public boolean isvalid(TreeNode root, long lv, long rv) {
        if (root == null) return true;
        if (lv < root.val && root.val < rv) {
            return isvalid(root.left, lv, root.val) && isvalid(root.right, root.val, rv);
        } else {
            return false;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // return isvalid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
