import java.util.*;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int src) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Bellman-Ford
        for (int i = 1; i <= n - 1; i++) {

            for (int[] edge : times) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, dist[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;
        int src = 2;

        int ans = obj.networkDelayTime(times, n, src);

        System.out.println("Network Delay Time = " + ans);
    }
}