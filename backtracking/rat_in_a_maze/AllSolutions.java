package backtracking.rat_in_a_maze;

import java.util.ArrayList;
import java.util.List;

public class AllSolutions {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 1}};
        List<int[][]> paths = new ArrayList<>();
        boolean res = solve(0, 0, maze, new int[maze.length][maze[0].length], 4, paths);
        System.out.println("Maze");
        print(maze);
        if (res) {
            for (int[][] element : paths)
                print(element);
        } else {
            System.out.println("No solution found");
        }
    }

    private static void print(int[][] output) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static boolean solve(int r, int c, int[][] maze, int[][] buffer, int n, List<int[][]> paths) {
        if (r == n - 1 && c == n - 1 && maze[r][c] == 1) {
            int[][] clone = new int[buffer.length][buffer[0].length];
            buffer[n - 1][n - 1] = 1;
            for (int i = 0; i < buffer.length; i++)
                System.arraycopy(buffer[i], 0, clone[i], 0, buffer[i].length);
            paths.add(clone);
            return true;
        }
        if (isSafe(r, c, maze, n)) {
            buffer[r][c] = 1;
            solve(r + 1, c, maze, buffer, n, paths);
            solve(r, c + 1, maze, buffer, n, paths);
            buffer[r][c] = 0;
        }
        return paths.size() > 0;
    }

    private static boolean isSafe(int r, int c, int[][] maze, int n) {
        return r < n && c < n && maze[r][c] == 1;
    }
}

