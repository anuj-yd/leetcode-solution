class Solution {

    class DSU {
        int[] prnt;
        int[] size;

        public DSU(int n) {
            prnt = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                prnt[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (prnt[x] != x) {
                prnt[x] = find(prnt[x]);
            }
            return prnt[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return false;

            if (size[px] < size[py]) {
                prnt[px] = py;
                size[py] += size[px];
            } else {
                prnt[py] = px;
                size[px] += size[py];
            }

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        DSU d = new DSU(n + 1);

        for (int[] ed : edges) {

            int u = ed[0];
            int v = ed[1];

            if (!d.union(u, v)) {
                return ed;
            }
        }

        return new int[0];
    }
}