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
    public void inorder(TreeNode root,ArrayList<Integer> ans){
        if(root == null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);

    }
    public int kthSmallest(TreeNode root, int k) {
        if(k==0) return 0;
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans.get(k-1);

    }
}