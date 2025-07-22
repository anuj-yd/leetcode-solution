class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return countPaths(root, targetSum)
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }

    private int countPaths(TreeNode node, long target) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == target) count++;

        count += countPaths(node.left, target - node.val);
        count += countPaths(node.right, target - node.val);

        return count;
    }
}
