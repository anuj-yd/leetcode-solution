// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         Map<Integer,Integer> map = new HashMap<>();

//         for(int num : nums){
//             map.put(num,map.getOrDefault(num,0)+1);
//         }

//         for(int num : map.keySet()){
//             if(map.get(num)>1) return num;
//         }
//         return -1;
        
        
//     }
// }

class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
