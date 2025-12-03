class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int low = 0;
        int high = col-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int mxR = 0;

            for(int i = 0;i<row;i++){
                if(mat[i][mid]>mat[mxR][mid]){
                    mxR = i;
                }
            }

            boolean left = (mid-1>=0) && mat[mxR][mid]<mat[mxR][mid-1];
            boolean right = (mid+1<col) && mat[mxR][mid]<mat[mxR][mid+1];

            if(!left && !right){
                return new int[]{mxR,mid};
            }

            if(right){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return new int[]{-1,-1};
        
    }
}