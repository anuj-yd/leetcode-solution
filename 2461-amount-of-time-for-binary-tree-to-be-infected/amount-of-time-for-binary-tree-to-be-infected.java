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

    public TreeNode childParent(TreeNode root,
                                HashMap<TreeNode,TreeNode> map,
                                int start){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root,null);

        TreeNode startNode = null;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.val == start){
                startNode = curr;
            }

            if(curr.left != null){
                map.put(curr.left, curr);
                q.offer(curr.left);
            }

            if(curr.right != null){
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return startNode;
    }

    public int amountOfTime(TreeNode root, int start) {

        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        TreeNode startNode = childParent(root, map, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();

        q.offer(startNode);
        set.add(startNode);

        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;

            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();

                if(temp.left!=null && !set.contains(temp.left)){
                    burned = true;
                    q.offer(temp.left);
                    set.add(temp.left);
                }

                if(temp.right!=null && !set.contains(temp.right)){
                    burned = true;
                    q.offer(temp.right);
                    set.add(temp.right);
                }

                TreeNode parent = map.get(temp);
                if(parent != null && !set.contains(parent)){
                    burned = true;
                    set.add(parent);
                    q.offer(parent);
                }
            }

            if(burned) time++;
        }

        return time;
    }
}