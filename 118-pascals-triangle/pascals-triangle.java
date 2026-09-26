class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        if(numRows==1) return ans;
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        temp2.add(1);
        ans.add(temp2);
        if (numRows<=2) return ans;


        for(int i=2;i<numRows;i++){

            List<Integer> t = ans.get(i-1);
            List<Integer> tp = new ArrayList<>();
            tp.add(1);
            int v1 = 0;
            int v2 = 1;
            for(int j=0;j<i-1;j++){
                int sum = t.get(v1)+t.get(v2);
                tp.add(sum);
                v1++;
                v2++;

            }
            tp.add(1);
            ans.add(tp);
        }
        return ans;
        
    }
}