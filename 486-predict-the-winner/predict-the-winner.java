class Solution {

    public boolean solve(int i,int j,int s1,int s2,boolean p1,int[] nums){
        if(i>j){
            if(s1>=s2) return true;
            return false;
        }

        if(p1==false){

            boolean picki = solve(i+1,j,s1+nums[i],s2,true,nums);
            boolean pickj = solve(i,j-1,s1+nums[j],s2,true,nums);

            return picki || pickj;

        }else{

            boolean picki = solve(i+1,j,s1,s2+nums[i],false,nums);
            boolean pickj = solve(i,j-1,s1,s2+nums[j],false,nums);
            return picki && pickj;
        }
    }

    public boolean predictTheWinner(int[] nums) {

        int i = 0;
        int j = nums.length-1;
        int s1 = 0,s2 = 0;
        boolean p1 = false;
        return solve(i,j,s1,s2,p1,nums);
        
    }
}