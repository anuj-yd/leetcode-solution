import java.util.*;

class Solution {

    private int dist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy; // squared distance
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[] d = new int[6];

        d[0] = dist(p1, p2);
        d[1] = dist(p1, p3);
        d[2] = dist(p1, p4);
        d[3] = dist(p2, p3);
        d[4] = dist(p2, p4);
        d[5] = dist(p3, p4);

        Arrays.sort(d);

        // check:
        // 4 equal sides + 2 equal diagonals + side > 0
        return d[0] > 0 &&
               d[0] == d[1] &&
               d[1] == d[2] &&
               d[2] == d[3] &&
               d[4] == d[5];
    }
}