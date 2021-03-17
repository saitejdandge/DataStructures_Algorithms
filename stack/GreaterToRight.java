package stack;

import java.util.Stack;

public class GreaterToRight {

    public static void main(String[] args) {

        int a[] = {5, 2, 4, 3, 1, 14, 2, 4};
        int o[] = solve(a);
        for (int i : o)
            System.out.print(i + " ");
    }

    public static int[] solve(int[] a) {

        Stack<Integer> stack = new Stack<>();

        int n = a.length;

        for (int i = n - 1; i >= 0; i--) {

            int temp = a[i];
            if (stack.isEmpty()) {
                a[i] = -1;
            } else if (stack.peek() > a[i]) {
                a[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() <= a[i])
                    stack.pop();
                if (stack.isEmpty())
                    a[i] = -1;
                else
                    a[i] = stack.peek();
            }
            stack.push(temp);
        }

        return a;

    }
}
