class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i + 1, j + 1};
            }else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[0];

        // for(int i=0;i<numbers.length;i++){
        //     for(int j=numbers.length-1;j>0;j--){
        //         int sum = numbers[i]+numbers[j];
        //         if(sum == target){
        //             return new int[]{i+1,j+1};
        //         }else if(sum>target){
        //             j--;
        //         }else{
        //             i++;
        //         }
        //     }
        // }
        // return new int[0];

    }
}
