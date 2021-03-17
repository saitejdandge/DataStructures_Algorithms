package backtracking.n_queen;

import java.util.ArrayList;
import java.util.List;

public class AllSolutions {
    public static void main(String[] args) {
        find(11);
    }

    private static void print(boolean[][] output) {
        int n = output.length;
        System.out.println("-----------------" + n + "------------------");
        for (boolean[] booleans : output) {
            for (int j = 0; j < n; j++) {
                System.out.print(booleans[j] ? "Q" + "  " : "__" + "  ");
            }
            System.out.println();
        }
        System.out.println("-----------------" + n + "------------------");
    }

    public static void find(int n) {
        boolean[][] output = new boolean[n][n];
        List<boolean[][]> solutions = new ArrayList<>();
        boolean result = solve(0, output, solutions, n);
        if (result) {
            System.out.println(solutions.size() + " solutions");
//            for (boolean[][] t : solutions) {
//                print(t);
//            }
        } else {
            System.out.println("No solution found");
        }
    }

    public static boolean solve(int col, boolean[][] buffer, List<boolean[][]> solutions, int n) {
        if (col == n) {
            boolean[][] clone = new boolean[buffer.length][buffer[0].length];
            for (int i = 0; i < buffer.length; i++)
                System.arraycopy(buffer[i], 0, clone[i], 0, buffer[i].length);
            solutions.add(clone);
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, buffer, n)) {
                buffer[i][col] = true;
                solve(col + 1, buffer, solutions, n);
                buffer[i][col] = false;
            }
        }
        return solutions.size() > 0;
    }

    private static boolean isSafe(int row, int col, boolean[][] output, int n) {

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

