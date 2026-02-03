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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> InOrder = new ArrayList<>();
        // if(root==null) return InOrder;
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !st.isEmpty()){
            if(temp!=null){
                st.push(temp);
                temp = temp.left;
            }else{
                temp = st.pop();
                InOrder.add(temp.val);
                temp = temp.right;
            }
            
        }
        return InOrder;
    }
}