package graphs.traversals;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        dfs("1", getGraph(), new HashSet<>());
        System.out.println();
        bfs("2", getGraph());
    }

    private static void bfs(String src, Map<String, List<Edge>> graph) {
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (visited.contains(current))
                continue;
            System.out.print(current + " ");
            visited.add(current);
            for (Edge edge : graph.get(current)) {
                if (!visited.contains(edge.dest))
                    queue.add(edge.dest);
            }

        }
    }

    private static void dfs(String src, Map<String, List<Edge>> graph, HashSet<String> visited) {
        visited.add(src);
        System.out.print(src + " ");
        for (Edge edge : graph.get(src)) {
            if (!visited.contains(edge.dest))
                dfs(edge.dest, graph, visited);
        }
    }


    private static Map<String, List<Edge>> getGraph() {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i <= 6; i++)
            graph.put(i + "", new ArrayList<>());

        addEdge(graph, "0", "1");
        addEdge(graph, "0", "2");

        addEdge(graph, "1", "0");
        addEdge(graph, "1", "4");

        addEdge(graph, "2", "0");
        addEdge(graph, "2", "3");


        addEdge(graph, "3", "2");
        addEdge(graph, "3", "1");

        addEdge(graph, "4", "1");
        addEdge(graph, "4", "5");

        addEdge(graph, "5", "4");
        addEdge(graph, "5", "6");

        addEdge(graph, "6", "4");
        addEdge(graph, "6", "5");


        return graph;
    }

    private static void addEdge(Map<String, List<Edge>> graph, String src, String dest) {
        graph.get(src).add(new Edge(src, dest, 0));
    }

    private static class Edge {
        String src, dest;
        double distance;

        public Edge(String src, String dest, double distance) {
            this.src = src;
            this.dest = dest;
            this.distance = distance;
        }
    }
}
