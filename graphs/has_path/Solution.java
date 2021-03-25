package graphs.has_path;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        int verices = 7;
        ArrayList<Edge>[] graph = new ArrayList[verices];
        for (ArrayList<Edge> element : graph)
            element = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 3, 3));

        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 2, 3));

        graph[2].add(new Edge(2, 1, 3));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 5, 3));

        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 3, 3));


    }

    private static class Edge {
        int src;
        int dest;
        int value;

        public Edge(int src, int dest, int value) {
            this.src = src;
            this.dest = dest;
            this.value = value;
        }
    }
}
