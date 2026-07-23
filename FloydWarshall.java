import java.util.*;

public class FloydWarshall {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];

        // Initialize
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
            dist[i][i] = 0;
        }

        // Add Edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][via] != (int)1e9 &&
                        dist[via][j] != (int)1e9) {

                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][via] + dist[via][j]
                        );
                    }
                }
            }
        }

        int city = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (dist[i][j] <= distanceThreshold)
                    count++;
            }

            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
    }

    public static void main(String[] args) {

        FloydWarshall obj = new FloydWarshall();

        int n = 4;

        int[][] edges = {
                {0,1,3},
                {1,2,1},
                {1,3,4},
                {2,3,1}
        };

        int threshold = 2;

        int ans = obj.findTheCity(n, edges, threshold);

        System.out.println("Answer = " + ans);
    }
}