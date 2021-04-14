package graphs.cycle_detection;

import java.util.*;

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {

        TreeMap<Integer, List<Integer>> graph = new TreeMap<>();
        graph.put(0, Collections.singletonList(1));
        graph.put(1, null);
        graph.put(2, Arrays.asList(1, 4));
        graph.put(4, Arrays.asList(0, 2));
        System.out.println(isCycle(graph));

    }

    public static boolean isCycle(Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.keySet().size() * 10];
        for (Integer curr : graph.keySet()) {
            if (dfs(curr, visited, graph, new ArrayList<>()))
                return true;
        }
        return false;
    }

    private static boolean dfs(Integer curr, boolean[] visited, Map<Integer, List<Integer>> graph, List<Integer> list) {
        if (visited[curr])
            return true;
        visited[curr] = true;
        if (graph.get(curr) != null)
            for (Integer n : graph.get(curr)) {
                if (dfs(n, visited, graph, list))
                    return true;
            }
        visited[curr] = false;
        return false;
    }


}
