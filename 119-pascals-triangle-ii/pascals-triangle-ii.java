class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>(Arrays.asList(1)));

        if(rowIndex == 0) return ans.get(0);

        for(int i=1;i<=rowIndex;i++){

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

        return ans.get(rowIndex);


        
    }
}