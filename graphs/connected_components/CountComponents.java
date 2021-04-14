package graphs.connected_components;

import java.util.*;

public class CountComponents {

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 0}, {1, 1, 0, 1}, {0, 0, 0, 1}, {1, 1, 1, 0}, {1, 1, 0, 1}};
        HashMap<Position, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    int val = bfs(a, i, j);
                    map.put(new Position(i, j), val);
                }
            }
        }
        for (Map.Entry<Position, Integer> entry : map.entrySet())
            System.out.println(entry.getKey().i + "," + entry.getKey().j + " : " + entry.getValue());
    }

    private static int dfs(int[][] a, int i, int j) {

        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] == 0 || a[i][j] == 2)
            return 0;

        a[i][j] = 0;

        return 1 + dfs(a, i + 1, j) +
                dfs(a, i - 1, j) +
                dfs(a, i, j + 1) +
                dfs(a, i, j - 1);

    }


    private static int bfs(int[][] a, int i, int j) {


        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(i, j));
        int count = 0;
        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            count++;
            a[currentPosition.i][currentPosition.j] = 0;
            List<Position> children = new ArrayList<>();
            children.add(new Position(currentPosition.i + 1, currentPosition.j));
            children.add(new Position(currentPosition.i - 1, currentPosition.j));
            children.add(new Position(currentPosition.i, currentPosition.j + 1));
            children.add(new Position(currentPosition.i, currentPosition.j - 1));
            for (Position c : children) {
                if (c.i >= 0 && c.i < a.length && c.j >= 0 && c.j < a[i].length && a[c.i][c.j] == 1)
                    queue.add(c);
            }
        }
        return count;
    }

    public static class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
