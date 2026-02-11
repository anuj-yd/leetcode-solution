/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
            
        }
        return sb.toString();  
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

        int i = 1;

        while(!q.isEmpty() && i < values.length){

            TreeNode parent = q.poll();
            // LEFT
            if(!values[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;

            // RIGHT
            if(!values[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;

        // if(data=="") return null;

        // Queue<TreeNode> q = new LinkedList<>();
        // String values[] = data.split(" ");
        // TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // q.add(root);
        // for(int i=1;i<values.length;i++){
        //     TreeNode prnt = q.poll();
        //     if(!values[i].equals("null")){
        //         TreeNode left = new TreeNode(Integer.parseInt(values[i]));
        //         prnt.left = left;
        //         q.add(left);
        //     }
        //     if(!values[++i].equals("null")){
        //         TreeNode right = new TreeNode(Integer.parseInt(values[i]));
        //         prnt.right = right;
        //         q.add(right);
        //     }
        // }
        // return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));