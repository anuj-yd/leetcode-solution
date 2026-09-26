class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        
        if(rowIndex==0) return temp;

        List<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        temp2.add(1);
        ans.add(temp2);

        if (rowIndex==1) return temp2;


        for(int i=2;i<rowIndex+1;i++){

            List<Integer> t = ans.get(i-1);
            List<Integer> tp = new ArrayList<>();
            tp.add(1);

            int v1 = 0;
            int v2 = 1;

            for(int j=0;j<i-1;j++){
                tp.add(t.get(v1++)+t.get(v2++));
            }
            tp.add(1);
            ans.add(tp);
        }
        return ans.get(rowIndex);
    }
}