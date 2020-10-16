package backtracking.n_queen;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++)
            find(i);

    }

    public static void find(int n) {
        System.out.println("-----------------" + n + "------------------");
        boolean output[][] = new boolean[n][n];
        boolean result = solve(0, output, n);
        if (result) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(output[i][j] ? "Q" + "  " : "__" + "  ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found");
        }

        System.out.println("-----------------" + n + "------------------");
    }

    public static boolean solve(int col, boolean[][] output, int n) {
        if (col == n)
            return true;

        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, output, n)) {
                output[i][col] = true;
                if (solve(col + 1, output, n))
                    return true;
                output[i][col] = false;
            }
        }

        return false;
    }

    private static boolean isSafe(int row, int col, boolean output[][], int n) {

        for (int i = 0; i < col; i++)
            if (output[row][i])
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; j--, i--) {
            if (output[i][j])
                return false;
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (output[i][j])
                return false;
        }

        return true;
    }
}
