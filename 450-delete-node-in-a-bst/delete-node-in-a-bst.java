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
    public TreeNode inorderSuc(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;
        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{

            // case 1 no  child
            if(root.left == null && root.right == null){
                return null;
            }

            //case 3 -> 2 child
            if(root.left!=null && root.right!=null){
                TreeNode insc = inorderSuc(root.right);
                root.val = insc.val;
                root.right = deleteNode(root.right,insc.val);
            }
            
            // case 2 -> 1 child
            else if(root.left == null){
                return root.right;
            }else{
                return root.left;
            } 

        }
        return root;
    }
}