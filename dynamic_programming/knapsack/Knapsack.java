package dynamic_programming. knapsack;

import java.util.Arrays;

public class Knapsack {

    static InputObj[] data;

    public static void main(String[] args) {

        data = new InputObj[3];
        data[0] = new InputObj(60, 10);
        data[1] = new InputObj(100, 20);
        data[2] = new InputObj(120, 30);
        System.out.println(solve(data.length, 30));

        int[][] t = new int[data.length + 1][30 + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        System.out.println("Max profit @Topdown: " + topDown(data.length, 30, t));
        System.out.println("Max profit @BottomUp: " + bottomUp(data.length, 30));
        printElements(data.length, 50, t);

    }

    public static int solve(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        if (data[n - 1].weight <= k) {
            return Math.max(data[n - 1].value + solve(n - 1, k - data[n - 1].weight), solve(n - 1, k));
        } else {
            return solve(n - 1, k);
        }
    }

    public static int topDown(int n, int k, int[][] t) {

        if (k == 0 || n == 0)
            return 0;
        if (t[n][k] != -1)
            return t[n][k];
        if (data[n - 1].weight <= k) {
            t[n][k] = Math.max(topDown(n - 1, k - data[n - 1].weight, t) + data[n - 1].value, topDown(n - 1, k, t));
            return t[n][k];
        } else {
            t[n][k] = topDown(n - 1, k, t);
            return t[n][k];
        }
    }

    public static int bottomUp(int n, int k) {

        int[][] t = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 0;

        for (int j = 0; j <= k; j++)
            t[0][j] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++) {
                if (data[i - 1].weight <= j) {
                    t[i][j] = Math.max(t[i - 1][j - data[i - 1].weight] + data[i - 1].value, t[i - 1][j]);
                } else
                    t[i][j] = t[i - 1][j];
            }

        printElements(n, k, t);
        return t[n][k];
    }

    public static void printElements(int n, int k, int[][] t) {

        int res = t[n][k];

        for (int i = n; (i > 0 && res > 0); i--) {
            if (res != t[i - 1][k]) {
                System.out.println(data[i - 1].value);
                res = res - data[i - 1].value;
                k = k - data[i - 1].weight;
            }
        }
    }

}