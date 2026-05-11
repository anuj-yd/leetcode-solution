class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            int idx = ans.size();
            while(num!=0){
                int d = num%10;
                ans.add(idx,d);
                num = num/10;
            }
        }
        int res[] = new int[ans.size()];
        int idx = 0;
        for(int num : ans){
            res[idx++] = num;
        }
        return res;
    }
}