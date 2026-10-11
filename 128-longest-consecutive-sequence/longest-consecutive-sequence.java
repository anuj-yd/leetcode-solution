class Solution {
    public int longestConsecutive(int[] arr) {

        Set<Integer> st = new HashSet<>();
        for(int val : arr) st.add(val);

        int len = 0;

        for(int val : st){
            if(!st.contains(val-1)){
                int curr = val;
                int count = 1;

                while(st.contains(curr+1)){
                    curr++;
                    count++;
                }

                len = Math.max(len,count);
            }
        }
        return len;
        
    }
}