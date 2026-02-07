/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void buildParent(TreeNode root,TreeNode prnt,Map<TreeNode,TreeNode> map){
        if(root==null) return;

        map.put(root,prnt);
        buildParent(root.left,root,map);
        buildParent(root.right,root,map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>(); // child->parent mapping to move upward
        buildParent(root, null, map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);

        List<Integer> ans = new ArrayList<>();
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist==k){
                for(TreeNode node : q){
                    ans.add(node.val);
                }
                break;
            }

            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();

                if(temp.left!=null && !visited.contains(temp.left)){
                    q.offer(temp.left);
                    visited.add(temp.left);

                }
                if(temp.right!=null && !visited.contains(temp.right)){
                    q.offer(temp.right);
                    visited.add(temp.right);
                }

                TreeNode parent = map.get(temp);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            dist++;
        }
        return ans;
    }
}