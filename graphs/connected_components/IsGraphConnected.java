package graphs.connected_components;

import graphs.utils.Edge;
import graphs.utils.GetGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class IsGraphConnected {
    public static void main(String[] args) {
        System.out.println(isConnected(GetGraph.getGraphWithMultipleComponents()));
        System.out.println(isConnected(GetGraph.getGraph()));
    }

    public static boolean isConnected(Map<String, List<Edge>> graph) {
        return getCount("0", graph, new HashSet<>()) == graph.keySet().size();
    }

    private static int getCount(String vertex, Map<String, List<Edge>> graph, HashSet<String> visited) {
        int ans = 1;
        visited.add(vertex);
        for (Edge e : graph.get(vertex)) {
            if (!visited.contains(e.dest)) {
                ans += getCount(e.dest, graph, visited);
            }
        }
        return ans;
    }
}
