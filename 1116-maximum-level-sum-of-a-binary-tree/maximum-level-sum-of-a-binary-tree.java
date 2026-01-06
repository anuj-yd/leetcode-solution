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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int lvl = 1;
        int maxlvl = 1;
        int maxsum = Integer.MIN_VALUE;


        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0;i<size;i++){
                TreeNode nbr = q.poll();
                sum += nbr.val;
                if(nbr.left!=null) q.offer(nbr.left);
                if(nbr.right!=null) q.offer(nbr.right);
            }
            if(sum>maxsum){
                maxsum=sum;
                maxlvl = lvl;
            }
            lvl++;
            
        }

        return maxlvl;

        
    }
}