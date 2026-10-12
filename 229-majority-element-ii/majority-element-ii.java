class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int freq = nums.length/3;

        Map<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);

            // if(map.get(val)>=freq){
            //     ans.add(val);
            // }
        }

        for(int key : map.keySet()){
            if(map.get(key)>freq) ans.add(key);
        }

        return ans;
        
    }
}