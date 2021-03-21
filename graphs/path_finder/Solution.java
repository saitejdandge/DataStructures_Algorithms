package graphs.path_finder;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] vertices = "0 1 2 3 4 5 6 7 8 9 10".split(" ");
        String[][] edges = new String[][]{
                {"0", "1"},
                {"0", "2"},
                {"1", "0"},
                {"1", "2"},
                {"1", "3"},
                {"1", "4"},
                {"3", "5"},
                {"5", "6"},
                {"5", "7"},
                {"5", "8"},
                {"8", "9"},
        };
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String vertex : vertices)
            graph.put(vertex, new ArrayList<>());
        for (String[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        finder(graph, new ArrayList<String>(), "0", "8");
    }

    public static void finder(HashMap<String, List<String>> graph, ArrayList<String> buffer, String start, String destination) {
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        HashSet<String> marked = new HashSet<>();
        List<String> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            marked.add(node);
            path.add(node);
            for (String neighbor : graph.get(node)) {
                if (neighbor.equals(destination)) {
                    System.out.println("Found " + neighbor);
                    System.out.println(path);
                    return;
                }
                if (!marked.contains(neighbor))
                    queue.add(neighbor);
            }
        }
    }
}
