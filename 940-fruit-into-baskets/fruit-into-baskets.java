class Solution {
    public int totalFruit(int[] arr) {

        int i=0,j=0,n=arr.length;
        // if(n<=1) return 0;

        int k = 2;
        int len = 0;

        Map<Integer,Integer> map = new HashMap<>();

        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>k){
                map.put(arr[i],map.get(arr[i])-1);

                if(map.get(arr[i])==0) map.remove(arr[i]);
                i++;
            }
                
            if(map.size()<=k){
                
                len = Math.max(len,j-i+1);
            }

            j++;
        }
        return len;
    }
}