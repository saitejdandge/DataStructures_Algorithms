package graphs.traversals;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        String[] nodes = "0 1 2 3 4 5".split(" ");
        String[][] edges = new String[][]{
                {"0", "1"},
                {"0", "2"},
                {"0", "3"},
                {"0", "4"},
                {"2", "4"},
                {"1", "5"},
                {"3", "5"},
        };
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String node : nodes)
            graph.put(node, new ArrayList<>());
        for (String[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        bfs(graph, "1");
    }

    public static void bfs(HashMap<String, List<String>> graph, String node) {
        Queue<String> queue = new LinkedList<>();
        queue.add(node);
        HashSet<String> marked = new HashSet<>();
        while (!queue.isEmpty()) {
            String result = queue.poll();
            if (!marked.contains(result))
                System.out.println(result);
            marked.add(result);
            for (String neighbor : graph.get(result)) {
                if (!marked.contains(neighbor))
                    queue.add(neighbor);
            }
        }
    }
}
