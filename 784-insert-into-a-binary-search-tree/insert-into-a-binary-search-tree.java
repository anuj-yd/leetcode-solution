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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode prnt = null;
        
        if(root == null) return new TreeNode(val);

        while(temp!=null){
            prnt = temp;
            if(temp.val<val){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        } 
        if(val<prnt.val){
            prnt.left = new TreeNode(val);
        }else{
            prnt.right = new TreeNode(val);
        }
        return root;
        
    }
}