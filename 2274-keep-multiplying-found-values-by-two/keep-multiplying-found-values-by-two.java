class Solution {
    public int findFinalValue(int[] nums, int original) {
        int org = original;
        HashSet<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     set.add(num);
        // }
        for(int num : nums){
            if(num%org==0) set.add(num);
        }
        while (set.contains(org)) {
            org *= 2;
        }
        return org;
    }
}