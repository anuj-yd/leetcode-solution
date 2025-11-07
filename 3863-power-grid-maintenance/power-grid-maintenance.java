import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> resultList = new ArrayList<>();
        
        // Initialize Union-Find with TreeSet for each component
        AdvancedUnionFind uf = new AdvancedUnionFind(c);
        
        // Process initial connections
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }
        
        // Process queries
        for (int[] query : queries) {
            int type = query[0];
            int station = query[1];
            
            if (type == 1) {
                resultList.add(uf.resolveMaintenance(station));
            } else {
                uf.setOffline(station);
            }
        }
        
        return resultList.stream().mapToInt(i -> i).toArray();
    }
    
    class AdvancedUnionFind {
        private int[] parent;
        private int[] rank;
        private boolean[] online;
        private TreeSet<Integer>[] onlineStations; // TreeSet for each component's online stations
        
        @SuppressWarnings("unchecked")
        public AdvancedUnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            online = new boolean[n + 1];
            onlineStations = new TreeSet[n + 1];
            
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
                online[i] = true;
                onlineStations[i] = new TreeSet<>();
                onlineStations[i].add(i);
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) return;
            
            // Always merge smaller set into larger set
            if (onlineStations[rootX].size() < onlineStations[rootY].size()) {
                // Merge rootX into rootY
                parent[rootX] = rootY;
                onlineStations[rootY].addAll(onlineStations[rootX]);
                onlineStations[rootX].clear();
            } else {
                // Merge rootY into rootX
                parent[rootY] = rootX;
                onlineStations[rootX].addAll(onlineStations[rootY]);
                onlineStations[rootY].clear();
                
                if (rank[rootX] == rank[rootY]) {
                    rank[rootX]++;
                }
            }
        }
        
        public void setOffline(int x) {
            if (!online[x]) return; // Already offline
            
            online[x] = false;
            int root = find(x);
            onlineStations[root].remove(x);
        }
        
        public int resolveMaintenance(int x) {
            if (online[x]) {
                return x;
            } else {
                int root = find(x);
                if (onlineStations[root].isEmpty()) {
                    return -1;
                }
                return onlineStations[root].first(); // Smallest element in TreeSet
            }
        }
    }
}