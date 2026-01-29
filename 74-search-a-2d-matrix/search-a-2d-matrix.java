class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0;i<row;i++){
            if(matrix[i][0]<=target&&target<=matrix[i][col-1]){
                int low = 0;
                int high = col-1;

                while(low<=high){
                    int mid = low+(high-low)/2;

                    if(matrix[i][mid]==target){
                        return true;
                    }else if(matrix[i][mid]<target){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }

                }
            }
        }
        return false;

        









        // int low = 0;
        // int high = col*row-1;
        // while(low<=high){
        //     int mid = low+(high-low)/2;
        //     int middle = matrix[mid/col][mid%col];
        //     // rowIndex = mid / totalColumns
        //     // colIndex = mid % totalColumns
        //     if(middle==target){
        //         return true;
        //     }
        //     else if(middle<=target){
        //         low = mid+1;
        //     }else{
        //         high = mid-1;
        //     }
        // }
        // return false;
        
    }
}