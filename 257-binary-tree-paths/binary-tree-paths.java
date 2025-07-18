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
    public void helper(TreeNode root,List<String> ans,String s){
        if(root == null) return;
        if(root.left == null && root.right==null){
            s+=root.val;
            ans.add(s);
            return;
        }
        s = s+root.val+"->";
        helper(root.left,ans,s);
        helper(root.right,ans,s);
    }
    // public void helper(TreeNode root,List<String> ans,String sb){
    //     if(root == null) return;
    //     sb.append(root.val);

    // }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        // StringBuiler sb = new StringBuiler();
        // helper(root,ans,sb);
        helper(root,ans,"");
        return ans;
    }
}