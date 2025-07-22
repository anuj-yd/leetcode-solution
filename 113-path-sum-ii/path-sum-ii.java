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
import java.util.*;

class Solution {
    public void pathSumHelper(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> ans){
        if (root == null) return;
        // current node value add karo
        path.add(root.val);
        // leaf node check karo
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                // agar sum match kare, to path ka ek copy ans mein daalo
                ans.add(new ArrayList<>(path));
            }
        }
        // left aur right subtree mein jao
        pathSumHelper(root.left, targetSum - root.val, path, ans);
        pathSumHelper(root.right, targetSum - root.val, path, ans);

        // backtrack - last element hatao
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumHelper(root, targetSum, path, ans);
        return ans;
    }
}
