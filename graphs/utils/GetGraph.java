package graphs.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetGraph {


    private static void addEdge(Map<String, List<Edge>> graph, String src, String dest) {
        graph.get(src).add(new Edge(src, dest, 0));
    }

    public static Map<String, List<Edge>> getGraphWithMultipleComponents() {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i <= 6; i++)
            graph.put(i + "", new ArrayList<>());

        addEdge(graph, "0", "1");

        addEdge(graph, "1", "0");

        addEdge(graph, "2", "3");


        addEdge(graph, "3", "2");

        addEdge(graph, "4", "5");
        addEdge(graph, "4", "6");

        addEdge(graph, "5", "4");
        addEdge(graph, "5", "6");

        addEdge(graph, "6", "4");
        addEdge(graph, "6", "5");


        return graph;
    }

    public static Map<String, List<Edge>> getGraph() {
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

    public static Map<String, List<Edge>> getGraph2() {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i <= 6; i++)
            graph.put(i + "", new ArrayList<>());

        addEdge(graph, "0", "1");
        addEdge(graph, "0", "2");

        addEdge(graph, "1", "0");

        addEdge(graph, "1", "3");
        addEdge(graph, "1", "4");

        addEdge(graph, "2", "0");
        addEdge(graph, "2", "3");


        addEdge(graph, "3", "2");
        addEdge(graph, "3", "1");
        addEdge(graph, "3", "5");

        addEdge(graph, "4", "1");
        addEdge(graph, "4", "5");
        addEdge(graph, "4", "6");

        addEdge(graph, "5", "4");
        addEdge(graph, "5", "6");
        addEdge(graph, "5", "3");


        addEdge(graph, "6", "4");
        addEdge(graph, "6", "5");


        return graph;
    }

}
