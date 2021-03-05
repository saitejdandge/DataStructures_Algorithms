package leetcode_problems.no_of_islands;

public class Solution {

    public static void main(String[] args) {

        int a[][] = {{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 0}};

        System.out.println(solve(a));
    }

    public static int solve(int a[][]) {
        int m = a.length;
        int n = a[0].length;
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    mark(a, i, j);
                    c += 1;
                }
            }
        }
        return c;
    }

    public static void mark(int a[][], int i, int j) {

        int m = a.length;
        int n = a[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || a[i][j] != 1)
            return;
        a[i][j] = 2;
        mark(a, i + 1, j);
        mark(a, i - 1, j);
        mark(a, i, j + 1);
        mark(a, i, j - 1);

    }
}
