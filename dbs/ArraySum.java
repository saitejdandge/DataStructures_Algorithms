package dbs;

import java.util.ArrayList;
import java.util.List;

public class ArraySum {

    public static void main(String[] args) {
        System.out.println(solve());

    }

    public static List<Integer> solve() {

        int[][] t = {{1, 2}, {3, 2}, {2, 2}};
        List<Integer> sums = getSums(t);

        int[][] input = {{3,5}};
        int q = input.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            result.add(getCount(input[i][0], input[i][1], sums));
        }
        return result;
    }

    public static int getCount(int l, int r, List<Integer> sums) {
        return sums.stream().filter(integer -> integer >= l && integer <= r).reduce(0, (count, value) -> count + 1);
    }

    public static List<Integer> getSums(int[][] t) {

        int m = t.length;
        int n = t[0].length;
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += t[i][j];
            }
            sums.add(sum);
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += t[j][i];
            }
            sums.add(sum);
        }
        System.out.println(sums);
        return sums;
    }
}
