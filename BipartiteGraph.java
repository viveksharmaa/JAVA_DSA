import java.util.*;

public class BipartiteGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int color[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {

                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {

                        Edge e = graph[curr].get(j);

                        if (color[e.dest] == -1) {

                            color[e.dest] = 1 - color[curr];
                            q.add(e.dest);

                        } else if (color[e.dest] == color[curr]) {

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void printColor(int color[]) {

        System.out.println("\nVertex\tColor");

        for (int i = 0; i < color.length; i++) {

            if (color[i] == 0) {
                System.out.println(i + "\tYellow");
            } else {
                System.out.println(i + "\tBlue");
            }
        }
    }

    public static void checkBipartite(ArrayList<Edge>[] graph) {

        int color[] = new int[graph.length];

        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        boolean isBipartite = true;

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {

                    int curr = q.remove();

                    for (Edge e : graph[curr]) {

                        if (color[e.dest] == -1) {

                            color[e.dest] = 1 - color[curr];
                            q.add(e.dest);

                        } else if (color[e.dest] == color[curr]) {

                            isBipartite = false;
                            break;
                        }
                    }

                    if (!isBipartite) {
                        break;
                    }
                }
            }

            if (!isBipartite) {
                break;
            }
        }

        if (isBipartite) {
            System.out.println("Graph is Bipartite");
            printColor(color);
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        checkBipartite(graph);
    }
}