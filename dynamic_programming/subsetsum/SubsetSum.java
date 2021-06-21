package dynamic_programming.subsetsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    static int[] data = {0, 1, 1, 0, 0};

    public static void main(String[] args) {
        int sum = 1;
        int[][] t = new int[data.length + 1][sum + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        int zeros = 0;
        for (int i : data) {
            if (i == 0)
                zeros++;
        }
        int zerosValue = ((int) (Math.pow(2, zeros)));
        System.out.println(topDown(data.length, sum, t) * zerosValue);
        System.out.println(bottomUp(data, sum) * zerosValue);
        System.out.println(bottomUpSpaceOptimized(data, sum) * zerosValue);
    }

    public static int bottomUp(int[] a, int sum) {
        int[][] t = new int[a.length + 1][sum + 1];
        t[0][0] = 1;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[i][j] = 1;
                } else if (a[i - 1] <= j && a[i - 1] != 0) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[a.length][sum];
    }

    public static int bottomUpSpaceOptimized(int[] a, int sum) {
        int[][] t = new int[2][sum + 1];
        int bi = 0;
        t[0][0] = 1;
        for (int i = 1; i <= a.length; i++) {
            bi = i % 2;
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[bi][j] = 1;
                } else {
                    if (a[i - 1] <= j && a[i - 1] != 0) {
                        t[bi][j] = t[1 - bi][j] + t[1 - bi][j - a[i - 1]];
                    } else {
                        t[bi][j] = t[1 - bi][j];
                    }
                }
            }
        }
        return t[bi][sum];
    }

    public static int solve(int n, int sum, List<Integer> buffer, List<List<Integer>> result) {

        if (sum == 0) {
            result.add(new ArrayList<>(buffer));
            return 1;
        }
        if (sum < 0 || n == 0)
            return 0;
        buffer.add(Integer.valueOf(data[n - 1]));
        int x = solve(n - 1, sum - data[n - 1], buffer, result);
        buffer.remove(Integer.valueOf(data[n - 1]));
        int y = solve(n - 1, sum, buffer, result);
        return x + y;
    }

    public static int topDown(int n, int sum, int[][] t) {

        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        if (t[n][sum] != -1) {
            return t[n][sum];
        }

        if (data[n - 1] <= sum && data[n - 1] != 0) {
            int inclusive = topDown(n - 1, sum - data[n - 1], t);
            int exclusive = topDown(n - 1, sum, t);
            t[n][sum] = inclusive + exclusive;
        } else {
            t[n][sum] = topDown(n - 1, sum, t);
        }
        return t[n][sum];
    }

}