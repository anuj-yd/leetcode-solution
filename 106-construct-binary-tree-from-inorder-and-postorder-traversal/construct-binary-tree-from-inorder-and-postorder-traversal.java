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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
    }

    private TreeNode helper(int[] postorder,int ps,int pe,int[] inorder,int is,int ie,
    Map<Integer,Integer> inMap ){
        if(ps>pe||is>ie) return null;

        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(root.val);
        int leftCount = inRoot-is;

        root.left = helper(postorder,
                           ps,
                           ps + leftCount - 1,
                           inorder,
                           is,
                           inRoot - 1,
                           inMap);

        // ✅ RIGHT subtree
        root.right = helper(postorder,
                            ps + leftCount,
                            pe - 1,
                            inorder,
                            inRoot + 1,
                            ie,
                            inMap);

        return root;
    }
}