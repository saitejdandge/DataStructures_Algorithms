package harish_problem;

import java.util.HashMap;

public class Solution {

    public static void main(String args[]) {

        int a[] = { 2, 3 };
        int b[] = { 4 };
        int c[] = { 2, 3 };
        int d[] = { 1, 2 };

        int bg = 10;
        int state[][][][][][] = new int[a.length + 1][b.length + 1][c.length + 1][d.length + 1][5][bg + 1];
        for (int i = 0; i <= a.length; i++)
            for (int j = 0; j <= b.length; j++)
                for (int k = 0; k <= c.length; k++)
                    for (int l = 0; l <= d.length; l++)
                        for (int m = 0; m <= 4; m++)
                            for (int n = 0; n <= bg; n++)
                                state[i][j][k][l][m][n] = -1;
        System.out.print(solve(a, b, c, d, 10, a.length, b.length, c.length, d.length, 0, state));
    }

    public static int solve(int a[], int b[], int c[], int d[], int bg, int p1, int p2, int p3, int p4, int count,
            int state[][][][][][]) {

        if (state[p1][p2][p3][p4][count][bg] != -1)
            return state[p1][p2][p3][p4][count][bg];

        if (count == 0) {
            if (p1 == 0)
                return 0;
            if (a[p1 - 1] <= bg) {
                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg - a[p1 - 1], p1 - 1, p2, p3, p4, count + 1, state)
                        + solve(a, b, c, d, bg, p1 - 1, p2, p3, p4, count, state);
            } else {
                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg, p1 - 1, p2, p3, p4, count, state);
            }
            return state[p1][p2][p3][p4][count][bg];
        }
        if (count == 1) {

            if (p2 == 0)
                return 0;
            if (b[p2 - 1] <= bg) {

                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg - b[p2 - 1], p1, p2 - 1, p3, p4, count + 1, state)
                        + solve(a, b, c, d, bg, p1, p2 - 1, p3, p4, count, state);
            } else {

                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg, p1, p2 - 1, p3, p4, count, state);
            }
            return state[p1][p2][p3][p4][count][bg];
        }
        if (count == 2) {

            if (p3 == 0)
                return 0;
            if (c[p3 - 1] <= bg) {

                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg - c[p3 - 1], p1, p2, p3 - 1, p4, count + 1, state)
                        + solve(a, b, c, d, bg, p1, p2, p3 - 1, p4, count, state);
            } else {

                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg, p1, p2, p3 - 1, p4, count, state);
            }
            return state[p1][p2][p3][p4][count][bg];
        }
        if (count == 3) {
            if (p4 == 0)
                return 0;
            if (d[p4 - 1] <= bg) {

                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg - d[p4 - 1], p1, p2, p3, p4 - 1, count + 1, state)
                        + solve(a, b, c, d, bg, p1, p2, p3, p4 - 1, count, state);
            } else {

                state[p1][p2][p3][p4][count][bg] = solve(a, b, c, d, bg, p1, p2, p3, p4 - 1, count, state);
            }
            return state[p1][p2][p3][p4][count][bg];
        } else if (count == 4)
            return 1;
        else
            return 0;

    }
}
