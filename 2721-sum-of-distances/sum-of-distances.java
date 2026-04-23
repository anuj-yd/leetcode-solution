class Solution {
    public long[] distance(int[] nums) {
        // integer,index
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        long ans[] = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> ls=new ArrayList<>();
                ls.add(i);
                map.put(nums[i],ls);

            }
        }
        
        for(int key:map.keySet()){
            List<Integer> ls = map.get(key);
            if(ls.size()==1){
                ans[ls.get(0)] = 0;
            }else{
                long[] prefixSum=new long[ls.size()];
                prefixSum[0]=ls.get(0);
                for(int i=1;i<prefixSum.length;i++){
                    prefixSum[i]=prefixSum[i-1]+ls.get(i);
                }

                for(int i=0;i<ls.size();i++){
                    int iref=ls.get(i);

                    long leftcount=i;
                    long rightCount=ls.size()-i-1;

                    long leftSum=(leftcount<=0)?0:iref*leftcount-prefixSum[i-1];
                    long rightSum=(rightCount<=0)?0:prefixSum[ls.size()-1]-prefixSum[i]-iref*rightCount;

                    ans[iref]=leftSum+rightSum;

                }
                
            }
        }

        return ans;

    }
}