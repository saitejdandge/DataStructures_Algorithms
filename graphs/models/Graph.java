package graphs.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private final List<Vertex> vertices;
    private final HashMap<Integer, Vertex> mapping;

    public Graph() {
        mapping = new HashMap<>();
        vertices = new ArrayList<>();
    }

    public void addEdge(int src, int dest) {
        checkAndAddVertex(src);
        checkAndAddVertex(dest);
        mapping.get(src).edges.add(new Edge(dest, 0));
    }


    public List<Integer> getTopSort() {
        List<Integer> result = new ArrayList<>();
        for (Vertex vertex : this.vertices) {
            boolean containsCycle = dfsTraverse(vertex, result);
            if (containsCycle)
                return new ArrayList<>();
        }
        return result;
    }

    private boolean dfsTraverse(Vertex vertex, List<Integer> result) {
        if (vertex.state == state.DONE)
            return false;
        if (vertex.state == state.PROGRESS)
            return true;

        vertex.state = state.PROGRESS;
        for (Edge edge : vertex.edges) {
            boolean containsCycle = dfsTraverse(mapping.get(edge.destination), result);
            if (containsCycle)
                return true;
        }


        vertex.state = state.DONE;
        result.add(vertex.value);
        return false;
    }

    private void checkAndAddVertex(int val) {
        if (!mapping.containsKey(val)) {
            Vertex vertex = new Vertex(val);
            mapping.put(val, vertex);
            vertices.add(vertex);
        }
    }

    enum state {
        TODO, PROGRESS, DONE;
    }

    static class Vertex {
        private int value;
        private List<Edge> edges;
        private state state;

        public Vertex(int value) {
            this.value = value;
            this.edges = new ArrayList<>();
            this.state = Graph.state.TODO;
        }
    }

    static class Edge {
        private final int destination;
        private int distance;

        public Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }
}
