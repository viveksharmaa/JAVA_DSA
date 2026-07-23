import java.util.*;

class P1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Create Graph
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Add Edges
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 3: BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(source);
        vis[source] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();

            // Destination Found
            if (curr == destination) {
                return true;
            }

            for (int neigh : graph[curr]) {

                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.offer(neigh);
                }
            }
        }

        return false;
    }
   public static void main(String[] args) {

        P1971 obj = new P1971();

        int n = 6;

        int[][] edges = {
            {0,1},
            {0,2},
            {3,5},
            {5,4},
            {4,3}
        };

        int source = 0;
        int destination = 5;

        boolean ans = obj.validPath(n, edges, source, destination);

        System.out.println(ans);
    }
}