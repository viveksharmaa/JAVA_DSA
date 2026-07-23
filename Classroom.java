import java.util.*;

public class NQueens {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        // Initialize each ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Add edges
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
    }

    public static void main(String args[]) {

        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // Print neighbours of vertex 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);

            System.out.println("Destination : " + e.dest);
            System.out.println("Weight      : " + e.wt);
            System.out.println("-----");
        }
    }
}