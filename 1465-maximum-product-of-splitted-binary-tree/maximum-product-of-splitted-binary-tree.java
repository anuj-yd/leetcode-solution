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

    long maxProduct = 0;
    long totalSum = 0;
    static final int MOD = 1_000_000_007;

    // STEP 1: Total sum of tree
    private long totalTreeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalTreeSum(root.left) + totalTreeSum(root.right);
    }

    // STEP 2: DFS to calculate subtree sum and product
    private long dfs(TreeNode root) {
        if (root == null) return 0;

        long left = dfs(root.left);
        long right = dfs(root.right);

        long subTreeSum = root.val + left + right;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = totalTreeSum(root);
        dfs(root);
        return (int)(maxProduct % MOD);
    }
}
