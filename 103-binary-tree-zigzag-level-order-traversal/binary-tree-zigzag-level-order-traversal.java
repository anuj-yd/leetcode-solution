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
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public void nthlevel(TreeNode root,int n,List<Integer> zig){
        if(root == null) return;
        if(n==1) {
            zig.add(root.val); 
            return;
        }
        nthlevel(root.right,n-1,zig);
        nthlevel(root.left,n-1,zig);
    }
    public void nthlevel2(TreeNode root,int n,List<Integer> zig){
        if(root == null) return;
        if(n==1) {
            zig.add(root.val);
            return;
        }
        nthlevel2(root.left,n-1,zig);
        nthlevel2(root.right,n-1,zig);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int level = height(root);
        for(int i=1;i<=level;i++){
            List<Integer> zig = new ArrayList<>();
            if(i%2==0){
                nthlevel(root,i,zig);
            }else{
                nthlevel2(root,i,zig);

            }
            ans.add(zig);
        }
        return ans;
            
    }
}