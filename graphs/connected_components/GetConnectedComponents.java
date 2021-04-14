package graphs.connected_components;

import graphs.utils.Edge;
import graphs.utils.GetGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GetConnectedComponents {

    public static void main(String[] args) {
        System.out.println(getComponents());
    }


    public static List<List<String>> getComponents() {
        List<List<String>> components = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Map<String, List<Edge>> graph = GetGraph.getGraphWithMultipleComponents();
        for (String vertex : graph.keySet()) {
            ArrayList<String> component = new ArrayList<>();
            if (!visited.contains(vertex)) {
                solve(vertex, graph, component, visited);
                components.add(component);
            }
        }
        return components;
    }

    private static void solve(String vertex, Map<String, List<Edge>> graph,
                              ArrayList<String> component, HashSet<String> visited) {
        visited.add(vertex);
        component.add(vertex);
        for (Edge edge : graph.get(vertex)) {
            if (!visited.contains(edge.dest)) {
                solve(edge.dest, graph, component, visited);
            }
        }
    }
}
