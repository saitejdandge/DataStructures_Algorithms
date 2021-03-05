package backtracking.sudoko_solver;

public class Solution {

    public static void main(String[] args) {

        int grid[][] = {{0, 0, 4, 0, 0, 0, 0, 6, 7},
                {3, 0, 0, 4, 7, 0, 0, 0, 5},
                {1, 5, 0, 8, 2, 0, 0, 0, 3},

                {0, 0, 6, 0, 0, 0, 0, 3, 1},
                {8, 0, 2, 1, 0, 5, 6, 0, 4},
                {4, 1, 0, 0, 0, 0, 9, 0, 0},

                {7, 0, 0, 0, 8, 0, 0, 4, 6},
                {6, 0, 0, 0, 1, 2, 0, 0, 0},
                {9, 3, 0, 0, 0, 0, 7, 1, 0}};
        int n = grid.length;
        solve(grid, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int grid[][], int n) {

        int r = 0;
        int c = 0;
        boolean broke = false;
        for (r = 0; r < n; r++) {
            for (c = 0; c < n; c++)
                if (grid[r][c] == 0) {
                    broke = true;
                    break;
                }
            if (broke)
                break;
        }

        if (r == n && c == n) {
            return true;
        }
        for (int value = 1; value <= n; value++) {

            if (isSafe(r, c, grid, n, value)) {
                grid[r][c] = value;
                if (solve(grid, n))
                    return true;
                grid[r][c] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int r, int c, int grid[][], int n, int value) {

        for (int i = 0; i < n; i++)
            if (grid[i][c] == value || grid[r][i] == value)
                return false;
        int s = (int) Math.sqrt(n);
        int gR = r - (r % s);
        int gC = c - (c % s);

        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                if (grid[gR + i][gC + j] == value)
                    return false;

        return true;
    }
}
