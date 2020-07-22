package knapsack;

public class RecursiveSolution {

    static InputObj[] objs;

    public static void main(String[] args) {

        objs = new InputObj[3];
        // for (int i = 0; i < 1000; i++) {
        // objs[i] = new InputObj(i, 2 * i);
        // }
        objs[0] = new InputObj(60, 10);
        objs[1] = new InputObj(100, 20);
        objs[2] = new InputObj(120, 30);
        System.out.println(fun(objs.length, 50));

    }

    public static int fun(int n, int capacity) {
        // System.out.println("n = " + n + ": " + "capacity = " + capacity);
        if (n == 0 || capacity == 0)
            return 0;

        if (objs[n - 1].weight <= capacity) {
            return Math.max(objs[n - 1].value + fun(n - 1, capacity - objs[n - 1].weight), fun(n - 1, capacity));
        } else {
            return fun(n - 1, capacity);
        }

    }

}