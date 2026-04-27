class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int top=0,bottom=r-1;
        int left=0,right=c-1;
        while(left<=right && top<=bottom){
            // ---->
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // |
            // |
            // V
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            // <----
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }


            // ^
            // |
            // |
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;

            }
        }
        return ans;
    }
}