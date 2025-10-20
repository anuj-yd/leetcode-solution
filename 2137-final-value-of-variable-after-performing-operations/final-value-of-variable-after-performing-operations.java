class Solution {
    public int finalValueAfterOperations(String[] operations) {
        // int x = 0;
        // for(String s : operations){
        //    if(s.equals("++X") || s.equals("X++")){
        //         x++;
        //     }else{
        //         x--;
        //     }
        // }
        // return x;

        int X = 0;  
        
        for (String op : operations) {
            if (op.contains("+")) {
                X++;   
            } else {
                X--;  
            }
        }
        
        return X;
        
    }
}