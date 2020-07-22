package knapsack;

import java.util.Arrays;

public class TopDown {

    static int[][] ds;
    static InputObj[] objs;

    public static void main(String[] args) {

        objs = new InputObj[3];
        // for (int i = 0; i < 1000; i++) {
        // objs[i] = new InputObj(i, 2 * i);
        // }
        objs[0] = new InputObj(60, 10);
        objs[1] = new InputObj(100, 20);
        objs[2] = new InputObj(120, 30);

        int capacity = 50;
        ds = new int[objs.length + 1][capacity + 1];
        Arrays.stream(ds).forEach(a -> Arrays.fill(a, -1));
        System.out.println(fun(objs.length, capacity));

    }

    public static int fun(int n, int capacity) {
        // System.out.println("n = " + n + ": " + "capacity = " + capacity);
        if (n == 0 || capacity == 0) {
            ds[n][capacity] = 0;
            return ds[n][capacity];
        }
        if (ds[n][capacity] != -1)
            return ds[n][capacity];

        if (objs[n - 1].weight <= capacity) {
            ds[n][capacity] = Math.max(objs[n - 1].value + fun(n - 1, capacity - objs[n - 1].weight),
                    fun(n - 1, capacity));
            return ds[n][capacity];
        } else {
            ds[n][capacity] = fun(n - 1, capacity);
            return ds[n][capacity];
        }

    }

}