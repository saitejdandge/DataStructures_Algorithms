package graphs.flood_fill;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FloodFillBFS {
    public int[][] floodFill(int[][] b, int i, int j, int newColor) {
        return bfs(b, i, j, newColor, b[i][j]);

    }

    public int[][] bfs(int[][] b, int i, int j, int newColor, int original) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        while (!q.isEmpty()) {
            Node n = q.poll();
            b[n.i][n.j] = newColor; //Process

            //children
            List<Node> children = new ArrayList<>();
            children.add(new Node(n.i + 1, n.j));
            children.add(new Node(n.i - 1, n.j));
            children.add(new Node(n.i, n.j + 1));
            children.add(new Node(n.i, n.j - 1));

            for (Node c : children) {
                if (check(c, b) && b[c.i][c.j] == original && b[c.i][c.j] != newColor) {
                    q.add(c);
                }
            }

        }
        return b;

    }

    public boolean check(Node n, int[][] b) {
        return n.i >= 0 && n.i < b.length && n.j >= 0 && n.j < b[0].length;
    }

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}