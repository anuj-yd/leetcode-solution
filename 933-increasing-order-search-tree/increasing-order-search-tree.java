class Solution {
    private TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        curr = dummy;

        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Process current node
        node.left = null;       // Remove left child
        curr.right = node;      // Link previous node to current
        curr = node;            // Move current pointer forward

        inorder(node.right);
    }
}
