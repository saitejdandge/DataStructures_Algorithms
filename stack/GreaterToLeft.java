package stack;

import java.util.Stack;

public class GreaterToLeft {

    public static void main(String[] args) {

        int a[] = {4, 2, 14, 1, 3, 4, 2, 5};
        int output[] = solve(a);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }

    public static int[] solve(int a[]) {
        int n = a.length;
        int counter = 0;
        int output[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            if (stack.isEmpty()) {

                output[counter++] = -1;
            } else if (stack.peek() > a[i]) {

                output[counter++] = stack.peek();

            } else {

                while (!stack.isEmpty() && stack.peek() <= a[i])
                    stack.pop();

                if (stack.isEmpty()) {
                    output[counter++] = -1;
                } else {
                    output[counter++] = stack.peek();
                }
            }
            stack.push(a[i]);
        }

        return output;
    }
}
