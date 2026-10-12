class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>(Arrays.asList(1)));

        if(numRows == 1) return ans;
        
        for(int i=1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                int v1 = ans.get(i-1).get(j);
                int v2 = ans.get(i-1).get(j-1);
                temp.add(v1+v2);
            }

            temp.add(1);
            ans.add(temp);
        }

        return ans;
    }
}