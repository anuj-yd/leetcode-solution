class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = col*row-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int middle = matrix[mid/col][mid%col];
            if(middle==target){
                return true;
            }
            else if(middle<=target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
        
    }
}