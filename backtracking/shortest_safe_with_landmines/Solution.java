package backtracking.shortest_safe_with_landmines;

public class Solution {
    public static void main(String[] args) {

        int[][] maze = {{1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1}};
        int[][] output = new int[maze.length][maze[0].length];
        print(maze);
        markMine(maze);
        print(maze);
        System.out.println(solve(0, 0, maze, output, maze[0].length, 0));
    }

    private static void print(int[][] maze) {
        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    private static void markMine(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 0) {
                    mark(i, j, maze, 2);
                }
            }
        }
    }

    private static void mark(int i, int j, int[][] maze, int spread) {
        int m = maze.length;
        int n = maze[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || maze[i][j] == 2 || spread == 0)
            return;
        maze[i][j] = 2;
        mark(i + 1, j, maze, spread - 1);
        mark(i - 1, j, maze, spread - 1);
        mark(i, j + 1, maze, spread - 1);
        mark(i, j - 1, maze, spread - 1);
    }

    public static int solve(int r, int c, int[][] maze, int[][] output, int n, int count) {
        if (c == n - 1 && maze[r][c] == 1) {
            return count + 1;
        }
        if (isSafe(r, c, maze, n)) {
            output[r][c] = 1;
            count = Math.min(solve(r + 1, c, maze, output, n, count + 1),
                    solve(r, c + 1, maze, output, n, count + 1));
            output[r][c] = 0;
        } else {
            return Integer.MAX_VALUE;
        }
        return count;
    }

    private static boolean isSafe(int r, int c, int[][] maze, int n) {
        return r < n && c < n && maze[r][c] == 1;
    }
}
