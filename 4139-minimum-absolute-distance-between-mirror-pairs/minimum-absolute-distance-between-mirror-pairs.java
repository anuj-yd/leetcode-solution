class Solution {
    private int r(int num){
        int val = 0;
        while(num!=0){
            int d = num%10;
            val = 10*val+d;
            num = num/10;
        }
        return val;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num)){
                min = Math.min(min, i - map.get(num));
            }
            int rev = r(num);
            map.put(rev, i);
        }

        return min==Integer.MAX_VALUE ? -1 : min;
    }
}