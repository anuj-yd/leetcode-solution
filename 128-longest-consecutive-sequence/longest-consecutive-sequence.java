class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> s = new HashSet<>();

        for(int num : nums){
            s.add(num);
        }
        int longest = 0;
        for(int num : s){

            if(!s.contains(num-1)){
                int curr = num;
                int count = 1;

                while(s.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
        
    }
}