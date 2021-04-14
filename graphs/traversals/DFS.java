package graphs.traversals;

import graphs.utils.Edge;
import graphs.utils.GetGraph;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        dfs("1", GetGraph.getGraph(), new HashSet<>());
        System.out.println();
        bfs("2", GetGraph.getGraph());
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




}
