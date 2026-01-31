class Solution {
    // private int atMost(int[] nums,int k){
    //     int left = 0;
    //     int right = 0;

    //     int sum = 0;
    //     int odd = 0;
    //     int count = 0;
    //     while(right<nums.length){
    //        if(nums[right]%2!=0){
    //             odd++;
    //        }

    //        while(odd>k){
    //             if(nums[left]%2!=0){
    //                 odd--;
    //             }
    //             left++;
    //        }
    //        count += right-left+1;
    //        right++;
    //     }
    //     return count;
    // }
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        while(right<nums.length){
            sum+=nums[right]%2;

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            right++;

        }
        return count;
        // return atMost(nums,k)-atMost(nums,k-1);
        
        
    }
}