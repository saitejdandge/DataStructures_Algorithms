package graphs.cycle_detection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CycleDetectionUnDirectedGraph {
    public static void main(String[] args) {

        TreeMap<Integer, List<Integer>> graph = new TreeMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Arrays.asList(2));

        System.out.println(isCycle(graph));

    }

    public static boolean isCycle(Map<Integer, List<Integer>> graph) {
        int[] visited = new int[graph.keySet().size() * 10];
        for (Integer curr : graph.keySet()) {
            if (dfs(curr, visited, graph))
                return true;
        }
        return false;
    }

    private static boolean dfs(Integer curr, int[] visited, Map<Integer, List<Integer>> graph) {
        if (visited[curr] == 2)
            return true;

        visited[curr] = 1;
        if (graph.get(curr) != null)
            for (Integer n : graph.get(curr)) {
                if (visited[n] == 1) {
                    visited[n] = 2;
                } else if (dfs(n, visited, graph))
                    return true;

                //marking current to 1 again
                visited[curr] = 1;
            }

        visited[curr] = 0;
        return false;
    }


}
