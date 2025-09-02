class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;

        for (int i = 0; i < operations.length; i++) {
            String ch = operations[i];
            if (ch.equals("X++") || ch.equals("++X")) {
                X += 1;
            } else if (ch.equals("X--") || ch.equals("--X")) {
                X -= 1;
            }
        }
        return X;
    }
}
