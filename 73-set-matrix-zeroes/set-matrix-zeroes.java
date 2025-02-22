class Solution {
    public void setZeroes(int[][] matrix){
        // length of row and col
        int r=matrix.length;
        int c=matrix[0].length;
        // boolean array of rr and cc to check value of any row col is zero
        boolean rr[]=new boolean[r];
        boolean cc[]=new boolean[c];

        // loops to check if the any row having zero at it's index then assingn 
        // bool rr and cc as true;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    rr[i]=true;
                    cc[j]=true;
                }
            }
        }
// loop to check bool row is true or not
        for(int i=0;i<r;i++){
            if(rr[i]){
                for(int j=0;j<c;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

// loop to check bool col is true or not
        for(int j=0;j<c;j++) {
            if(cc[j]){
                for(int i=0;i<r;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(matrix[i][j]);
            }
        }       
    }
}