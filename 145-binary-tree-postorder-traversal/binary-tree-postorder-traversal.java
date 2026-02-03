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
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();
        List<Integer> PostOrder = new ArrayList<>();
        if(root==null) return PostOrder;
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode temp = st1.pop();
            st2.push(temp);
            if(temp.left!=null) st1.push(temp.left);
            if(temp.right!=null) st1.push(temp.right);
        }
        while(!st2.isEmpty()){
            PostOrder.add(st2.pop().val);
        }
        return PostOrder;
        
    }
}