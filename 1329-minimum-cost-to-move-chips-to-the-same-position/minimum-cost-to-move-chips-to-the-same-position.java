class Solution {
    public int minCostToMoveChips(int[] position){
        int e=0;
        int o=0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2==0){
                e++;
            }else{
                o++;
            }
        }
        return Math.min(e,o);



    }
}