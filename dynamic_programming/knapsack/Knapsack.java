package dynamic_programming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

    static InputObj[] data;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        data = new InputObj[4];
        data[0] = new InputObj(1, 1);
        data[1] = new InputObj(8, 5);
        data[2] = new InputObj(13, 3);
        data[3] = new InputObj(1, 2);
        System.out.println(solve(data.length, 5));

        int[][] t = new int[data.length + 1][30 + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        ArrayList<InputObj> list = new ArrayList<>();
        List<InputObj> finalResult = new ArrayList<>();
        System.out.println("Max profit @Topdown: " + topDown(data.length, 5, t, list, finalResult));
        System.out.println("-----------");
        for (InputObj i : finalResult)
            System.out.print(i.value);

//        System.out.println("Max profit @BottomUp: " + bottomUp(data.length, 30));
//        printElements(data.length, 30, t);

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

    public static int topDown(int n, int k, int[][] t, ArrayList<InputObj> list, List<InputObj> finalResult) {

        if (k == 0 || n == 0) {
            int s = list.stream().map(i -> i.value).reduce(0, Integer::sum);
            if (s >= max) {
                finalResult.clear();
                finalResult.addAll(list);
                max = s;
            }
            return 0;
        }
        if (t[n][k] != -1)
            return t[n][k];
        if (data[n - 1].weight <= k) {

            list.add(data[n - 1]);

            int x = topDown(n - 1, k - data[n - 1].weight, t, list, finalResult) + data[n - 1].value;
            list.remove(data[n - 1]);
            int y = topDown(n - 1, k, t, list, finalResult);

            t[n][k] = Math.max(x, y);
        } else {
            list.remove(data[n - 1]);
            t[n][k] = topDown(n - 1, k, t, list, finalResult);
        }
        return t[n][k];
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