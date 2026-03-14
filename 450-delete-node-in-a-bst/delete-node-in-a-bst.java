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
    public TreeNode getInorderSuc(TreeNode root){
        while(root!=null && root.left!=null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            //key ==root
            if(root.left==null){
                TreeNode temp = root.right;
                root = null;
                return temp;
            }else if(root.right == null){
                TreeNode temp = root.left;
                root = null;
                return temp;

            }else{
                TreeNode Is = getInorderSuc(root.right);
                root.val = Is.val;
                root.right = deleteNode(root.right,Is.val);
            }
        }
        return root;

    }
}