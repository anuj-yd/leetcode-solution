class Solution {
    public int longestConsecutive(int[] nums){

        HashSet<Integer> hs = new HashSet<>();

        for(int i : nums) hs.add(i);
        int maxlen = 0;

        for(int n : hs){
            if(!hs.contains(n-1)){
                int curr = n;
                int streak = 1;

                while(hs.contains(curr+1)){
                    streak++;
                    curr++;
                }
                maxlen = Math.max(maxlen,streak);
            }
        }
        return maxlen;
        
    }
}