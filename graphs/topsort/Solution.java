package graphs.topsort;

import graphs.models.Graph;

public class Solution {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(4, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 1);

        graph.getTopSort().forEach(System.out::println);

    }
}
