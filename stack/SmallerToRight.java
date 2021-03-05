package stack;

import java.util.Stack;

public class SmallerToRight {

    public static void main(String[] args) {
        int a[] = {4, 5, 2, 10, 8};
        int o[] = solve(a);
        for (int i : o)
            System.out.print(i + " ");
    }

    public static int[] solve(int a[]) {
        int n = a.length;
        int counter = n - 1;

        int output[] = new int[n];
        Stack<Integer> s = new Stack();
        for (int i = n - 1; i >= 0; i--) {

            if (s.isEmpty()) {
                output[counter--] = -1;
            } else if (s.peek() < a[i]) {
                output[counter--] = s.peek();
            } else {

                while (!s.isEmpty() && s.peek() >= a[i])
                    s.pop();
                if (s.isEmpty()) {
                    output[counter--] = -1;
                } else
                    output[counter--] = s.peek();
            }
            s.push(a[i]);

        }
        return output;
    }
}
