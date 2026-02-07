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
    
    // public void buildParent(TreeNode root,TreeNode prnt,Map<TreeNode,TreeNode> map){
    //     if(root==null) return;

    //     map.put(root,prnt);
    //     buildParent(root.left,root,map);
    //     buildParent(root.right,root,map);
    // }

    public void buildParent(TreeNode root, Map<TreeNode, TreeNode> map){

        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        map.put(root, null); // root has no parent

        while(!q.isEmpty()){

            TreeNode curr = q.poll();

            if(curr.left != null){
                map.put(curr.left, curr); // child -> parent
                q.offer(curr.left);
            }

            if(curr.right != null){
                map.put(curr.right, curr); // child -> parent
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>(); // child->parent mapping to move upward
        // buildParent(root, null, map);
        buildParent(root, map);
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