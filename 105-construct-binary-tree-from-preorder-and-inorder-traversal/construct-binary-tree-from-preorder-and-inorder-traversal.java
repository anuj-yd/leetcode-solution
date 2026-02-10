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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }
    private TreeNode helper(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,
    Map<Integer,Integer> inMap)
    {
        if(ps>pe||is>ie) return null;
        int rootVal = preorder[ps];
        TreeNode node = new TreeNode(rootVal);
        int inRoot = inMap.get(node.val);
        int countLeft = inRoot-is;
        node.left = helper(preorder,ps+1,ps+countLeft,inorder,is,inRoot-1,inMap);
        node.right = helper(preorder,ps+countLeft+1,pe,inorder,inRoot+1,ie,inMap);

        return node;
    }
}