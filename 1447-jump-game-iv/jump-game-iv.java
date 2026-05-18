// class Solution {

//     public int bfs(List<List<Integer>> adj){
//         int v = adj.size();
//         Queue<Integer> q = new LinkedList<>();
//         boolean visited[] = new boolean[v];
//         q.add(0);
//         visited[0] = true;
//         int count = 0;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 int node = q.poll();
//                 if(node == v - 1){
//                     return count;
//                 }
//                 for(int nbr : adj.get(node)){
//                     if(!visited[nbr]){
//                         visited[nbr] = true;
//                         q.add(nbr);
//                     }
//                 }
//             }
//             count++;
//         }

//         return -1;
//     }

//     public int minJumps(int[] arr) {

//         int n = arr.length;
//         if(n<=1) return 0;
//         if(arr[0] == arr[n-1]) return 1;
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for(int i = 0; i < n; i++){
//             if(i + 1 < n){
//                 adj.get(i).add(i + 1);
//             }
//             if(i - 1 >= 0){
//                 adj.get(i).add(i - 1);
//             }
//             for(int j = 0; j < n; j++){
//                 if(i != j && arr[i] == arr[j]){
//                     adj.get(i).add(j);
//                 }
//             }
//         }
//         return bfs(adj);
//     }
// }


import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if(n == 1) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // value -> indices
        for(int i = 0; i < n; i++) {

            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];

        q.add(0);
        visited[0] = true;

        int steps = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int node = q.poll();

                // reached end
                if(node == n - 1) {
                    return steps;
                }

                // i - 1
                if(node - 1 >= 0 && !visited[node - 1]) {

                    visited[node - 1] = true;
                    q.add(node - 1);
                }

                // i + 1
                if(node + 1 < n && !visited[node + 1]) {

                    visited[node + 1] = true;
                    q.add(node + 1);
                }

                // same value jumps
                if(map.containsKey(arr[node])) {

                    for(int nbr : map.get(arr[node])) {

                        if(!visited[nbr]) {

                            visited[nbr] = true;
                            q.add(nbr);
                        }
                    }

                    // IMPORTANT
                    map.remove(arr[node]);
                }
            }

            steps++;
        }

        return -1;
    }
}