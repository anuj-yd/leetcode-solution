/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                if(temp.children!=null){
                    for(Node child : temp.children){
                        q.offer(child);
                    }
                }
                
            }
        }
        return count;
        
        
    }
}