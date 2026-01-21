class Solution {
    public int totalFruit(int[] fruits) {
      int left = 0;
      int right = 0;
      int n = fruits.length;
      int len = 0;
      Map<Integer,Integer> mp = new HashMap<>();
      while(right<n){
        mp.put(fruits[right],mp.getOrDefault(fruits[right],0)+1);
        while(mp.size()>2){
            mp.put(fruits[left],mp.get(fruits[left])-1);
            if(mp.get(fruits[left])==0) mp.remove(fruits[left]);
            left++;
        }
        len = Math.max(right-left+1,len);
        right++;

      }
      return len;
        
    }
}