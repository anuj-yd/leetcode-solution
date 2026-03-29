import java.util.*;

class Solution {

    private int dist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        Set<Integer> set = new HashSet<>();

        set.add(dist(p1, p2));
        set.add(dist(p1, p3));
        set.add(dist(p1, p4));
        set.add(dist(p2, p3));
        set.add(dist(p2, p4));
        set.add(dist(p3, p4));
        
        return !set.contains(0) && set.size() == 2;
    }
}