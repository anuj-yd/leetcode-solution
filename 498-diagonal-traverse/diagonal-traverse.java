class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans[] = new int[m*n];
        int idx = 0;
        int count = 0;
        boolean isRev=false;
        //int thisvalcount=0;
        for(int c=0;c<=m+n;c++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(i+j==c){
                        // ans[idx++] = mat[i][j];
                        temp.add(mat[i][j]);
                        //thisvalcount++;
                    }
                    // if()
                }
            }
            if(!isRev) Collections.reverse(temp);
            for(int num:temp){
                ans[idx++]=num;
            }
            isRev=!isRev;

        }
        return ans;
        
    }
}