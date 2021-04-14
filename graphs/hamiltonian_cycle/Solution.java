package graphs.hamiltonian_cycle;

import graphs.utils.Edge;
import graphs.utils.GetGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String, List<Edge>> graph = GetGraph.getGraph2();
        solve("0", new HashSet<>(), 0, graph, "");
    }

    private static void solve(String src, HashSet<String> visited, int count, Map<String, List<Edge>> graph, String output) {

        if (count == graph.size() - 1) {
            boolean found = false;
            for (Edge e : graph.get(src)) {
                if (e.dest.equals("0")) {
                    found = true;
                    break;
                }
            }
            System.out.println(output + (found ? " cycle" : " path"));
            return;
        }
        visited.add(src);
        for (Edge edge : graph.get(src)) {
            if (!visited.contains(edge.dest)) {
                solve(edge.dest, visited, count + 1, graph, output + edge.dest + " ");
            }
        }
        visited.remove(src);
    }
}
