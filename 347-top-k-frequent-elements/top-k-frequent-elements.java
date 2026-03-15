class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }
            map.put(n,map.get(n)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));

        for(int val : map.keySet()){
            pq.add(new int[]{map.get(val),val});
        }
        int ans[] = new int[k];
        int idx = 0;
        while(k>0){
            int[] de = pq.poll();
            ans[idx++] = de[1];
            k--;
        }
        return ans;
    }
}