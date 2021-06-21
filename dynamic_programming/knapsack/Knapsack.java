package dynamic_programming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

    static InputObj[] data;


    public static void main(String[] args) {

        data = new InputObj[3];
        data[0] = new InputObj(180, 3);
        data[1] = new InputObj(120, 2);
        data[2] = new InputObj(-70, 0);

        int k = 3;

        int[][] t = new int[data.length + 1][k + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        ArrayList<InputObj> list = new ArrayList<>();
        List<List<InputObj>> finalResult = new ArrayList<>();
        int[] a = new int[]{Integer.MIN_VALUE};
        System.out.println("Max profit @Topdown: " + topDown(data.length, k, t, list, finalResult, 0, a));
        System.out.println("-----------");
        for (List<InputObj> res : finalResult) {
            for (InputObj i : res)
                System.out.print("[" + i.weight + ":" + i.value + "] ");
            System.out.println();
        }
//        System.out.println("Max profit @BottomUp: " + bottomUp(data.length, k));

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


    public static int topDown(int n, int k, int[][] t, ArrayList<InputObj> buffer, List<List<InputObj>> finalResult, int currentSum, int[] max) {

        if (k == 0 || n == 0) {
            return 0;
        }
        if (t[n][k] != -1) {
            return t[n][k];
        }

        if (data[n - 1].weight <= k) {

            buffer.add(data[n - 1]);
            int x = topDown(n - 1, k - data[n - 1].weight, t, buffer, finalResult, currentSum + data[n - 1].value, max) + data[n - 1].value;
            check(x, max, finalResult, buffer);

            buffer.remove(data[n - 1]);
            int y = topDown(n - 1, k, t, buffer, finalResult, currentSum, max);


            check(y, max, finalResult, buffer);
            t[n][k] = Math.max(x, y);
        } else {

            t[n][k] = topDown(n - 1, k, t, buffer, finalResult, currentSum, max);
            check(t[n][k], max, finalResult, buffer);

        }

        return t[n][k];
    }

    public static void check(int candi, int[] max, List<List<InputObj>> finalResult, List<InputObj> buffer) {
        if (candi >= max[0]) {
            System.out.println(candi + " is candidate");
            if (candi > max[0])
                finalResult.clear();
            finalResult.add(new ArrayList<>(buffer));
            max[0] = candi;
        }
    }

    public static int bottomUp(int n, int k) {

        int[][] t = new int[n + 1][k + 1];

        System.out.println(n + ":" + k);
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