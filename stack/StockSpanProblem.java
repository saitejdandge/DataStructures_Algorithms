package stack;

import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {

        int a[] = { 100, 80, 60, 70, 60, 75, 85 };
        int[] o = solve(a);
        for (int i : o)
            System.out.print(i + " ");
    }

    public static int[] solve(int[] a) {

        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int output[] = new int[n];
        int counter = 0;

        for (int i = 0; i < n; i++) {

            if (s.isEmpty()) {
                output[counter++] = -1;
            } else if (a[s.peek()] > a[i]) {
                output[counter++] = s.peek();
            } else {
                while (!s.isEmpty() && a[s.peek()] <= a[i]) {
                    s.pop();
                }
                if (s.isEmpty())
                    output[counter++] = -1;
                else
                    output[counter++] = s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < n; i++)
            output[i] = i - output[i];

        return output;
    }
}
