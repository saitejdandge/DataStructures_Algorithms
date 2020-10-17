package backtracking.rat_in_a_maze;

public class Solution {
    public static void main(String[] args) {

        int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
        int output[][] = new int[4][4];
        solve(0, 0, maze, output, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int r, int c, int maze[][], int output[][], int n) {
        if (r == n - 1 && c == n - 1) {
            return true;
        }

        if (isSafe(r, c, maze, n)) {

            output[r][c] = 1;
            if (solve(r + 1, c, maze, output, n) || solve(r, c + 1, maze, output, n))
                return true;
            output[r][c] = 0;
        }

        return false;
    }

    private static boolean isSafe(int r, int c, int[][] maze, int n) {

        return r < n && c < n && maze[r][c] == 1;
    }
}
