package stack;

import java.util.Arrays;

public class MaxAreaBinaryMatrix {

    public static void main(String[] args) {

        int[][] a = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println("ans " + solve(a));
    }

    public static int solve(int a[][]) {

        int m = a.length;
        int n = a[0].length;

        int[] vector;

        vector = Arrays.copyOf(a[0], a[0].length);

        int max = MaxAreaHistorgram.solve(vector);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0)
                    vector[j] = 0;
                else
                    vector[j] += a[i][j];
            }
            max = Math.max(max, MaxAreaHistorgram.solve(vector));
        }
        return max;

    }
}
