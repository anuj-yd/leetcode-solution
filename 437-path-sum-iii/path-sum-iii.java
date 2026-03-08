class Solution {

    public int dfs(TreeNode root, long currSum, int target, HashMap<Long,Integer> map){
        if(root == null) return 0;

        currSum += root.val;

        int count = map.getOrDefault(currSum - target, 0);

        map.put(currSum, map.getOrDefault(currSum,0) + 1);

        count += dfs(root.left, currSum, target, map);
        count += dfs(root.right, currSum, target, map);

        map.put(currSum, map.get(currSum) - 1); // backtrack

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);

        return dfs(root, 0, targetSum, map);
    }
}