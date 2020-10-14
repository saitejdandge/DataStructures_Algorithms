package dynamic_programming. tusharbday;

import java.util.ArrayList;
import java.util.List;

public class Dishes {

    public static void main(String[] args) {
        Dishes dishes = new Dishes();
        List<Integer> f = new ArrayList<>();
        f.add(2);
        f.add(3);
        f.add(1);
        f.add(5);
        f.add(4);

        List<Integer> d = new ArrayList<>();
        d.add(3);
        d.add(2);
        d.add(4);
        d.add(1);

        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(5);
        c.add(10);

        dishes.solve(f, d, c);
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> f, final List<Integer> d, final List<Integer> c) {

        int maxF = f.get(0);
        for (int i : f)
            maxF = Math.max(i, maxF);

        int t[][] = getTable(maxF, getArray(d), getArray(c));

        int sum = 0;
        for (int i = 0; i <= maxF; i++)
            if (f.contains(i)){
                System.out.println("f= "+i);
                sum += t[d.size()][i];
            }

        System.out.println("Ans " + sum);
        return sum;

    }

    public Integer[] getArray(List<Integer> x) {
        Integer[] o = new Integer[x.size()];
        for (int i = 0; i < x.size(); i++)
            o[i] = x.get(i);
        return o;
    }

    public int[][] getTable(int f, Integer d[], Integer c[]) {
        int t[][] = new int[d.length + 1][f + 1];

        int prev = 0;
        for (int j = 1; j <= f; j++) {
            System.out.println("init " + j + " " + d[0] + " " + Math.ceil(j / (d[0] * 1.0)));
            if (j > d[0]) {
                t[1][j] = ((int) Math.ceil(j / (d[0] * 1.0))) * c[0];
            } else
                t[1][j] = c[0];

        }

        for (int i = 2; i <= d.length; i++) {
            for (int j = 1; j <= f; j++) {
                if (d[i - 1] <= j) {
                    System.out.println("true " + c[i - 1] + t[i][j - d[i - 1]] + " vs " + t[i - 1][j]);
                    t[i][j] = Math.min(c[i - 1] + t[i][j - d[i - 1]], t[i - 1][j]);
                } 
                // else
                    t[i][j] = t[i - 1][j];
            }
        }
        for (int i = 0; i <= d.length; i++) {
            for (int j = 0; j <= f; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }

        return t;
    }
}
