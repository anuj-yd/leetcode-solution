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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        

        if(root==null) return 0;

        q.offer(new Pair(root,0));
        int maxWidth=0;
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0;
            int last = 0;
            int minIdx = q.peek().idx;

            for(int i=0;i<size;i++){
                Pair pair = q.poll();

                TreeNode temp = pair.node;
                int curIdx = pair.idx;

                if(i==0) first = curIdx;
                if(i==size-1) last = curIdx;

                if(temp.left!=null){
                    q.offer(new Pair(temp.left,2*curIdx+1));
                }
                if(temp.right!=null){
                    q.offer(new Pair(temp.right,2*curIdx+2));
                }
            }
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}