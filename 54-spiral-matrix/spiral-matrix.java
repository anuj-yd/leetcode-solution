class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0,btm = n-1;
        int left = 0,right = m-1;

        while(top<=btm && left<=right){

            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }

            top++;

            for(int i=top;i<=btm;i++){
                ans.add(matrix[i][right]);
            }

            right--;

            if(top<=btm){

                for(int i=right;i>=left;i--){
                    ans.add(matrix[btm][i]);
                }
                btm--;

            }
            

            if(left<=right){
                for(int i=btm;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
            }

            left++;

        }

        return ans;
    }
}