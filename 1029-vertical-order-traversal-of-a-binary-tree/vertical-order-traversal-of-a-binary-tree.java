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
    // ye islyr banay h taki ham queue pair daal ske kyuki hame node 
    //ke saath col bhi add krna h ki kis col mein h
    class Pair{
        TreeNode node;
        int lvl;
        int col;

        Pair(TreeNode node,int lvl,int col){
            this.node = node;
            this.lvl = lvl;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans; 
        Queue<Pair> q = new LinkedList<>();
        // coloum ka number or usi coloum ke value ko list mein save kr rha h sorted order;
        // TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map  = new TreeMap<>();

        q.offer(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            TreeNode temp = pair.node;
            int lvl = pair.lvl;
            int col = pair.col;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(lvl,new PriorityQueue<>());
            map.get(col).get(lvl).offer(temp.val);
            if(temp.left != null){
                q.offer(new Pair(temp.left,lvl+1,col-1)); 
            } 
            if(temp.right != null){ 
                q.offer(new Pair(temp.right,lvl+1,col+1)); 
            }
            
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){

            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }
        return ans;
    }
}