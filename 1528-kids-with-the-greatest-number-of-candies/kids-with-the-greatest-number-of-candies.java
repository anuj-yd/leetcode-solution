class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int total = candies[i] + extraCandies;
            result.add(total >= maxCandies);
        }
        
        return result;
    }
}