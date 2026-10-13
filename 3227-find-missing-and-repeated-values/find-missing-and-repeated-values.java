class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        

        int n = grid.length;
        int len = n*n;

        Map<Integer,Integer> map = new HashMap<>();
        int sum = len*(len+1)/2;
        int actSum = 0;
        int[] ans = new int[2];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                actSum += grid[i][j];
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
                if(map.get(grid[i][j])>1) ans[0] = grid[i][j];
            }
        }

        ans[1] = sum - actSum+ans[0];

        return ans;


        
        
    }
}