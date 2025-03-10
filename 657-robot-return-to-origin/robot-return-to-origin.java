class Solution {
    public boolean judgeCircle(String moves) {
        char [] c = moves.toCharArray();
        int x = 0; 
        int y = 0; 
        for (int i=0;i<c.length;i++){
            switch (c[i]) {
                case 'U':
                    y++; 
                    break;
                case 'D':
                    y--; 
                    break;
                case 'L':
                    x--; 
                    break;
                case 'R':
                    x++; 
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}