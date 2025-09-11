class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        // log(m*n);
        int n = matrix.length;
        int m = matrix[0].length;
        int s = 0;
        int e = m*n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            int midele = matrix[mid/m][mid%m];
            if(midele == target){
                return true;
            }else if(target<midele){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return false;
        

        // m*n time complexity h
        // int row = matrix.length;
        // int col = matrix[0].length;

        // int r = 0;
        // int c = col-1;

        // while(r<row && c>=0){
        //     if(matrix[r][c]==target){
        //         return true;
        //     }else if(matrix[r][c]<target){
        //         r++;
        //     }else{
        //         c--;
        //     }
        // }
        // return false;
        
    }
}