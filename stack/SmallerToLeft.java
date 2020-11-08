package stack;

import java.util.Stack;

public class SmallerToLeft {

    public static void main(String[] args) {

        int a[] = { 4, 5, 2, 10, 8 };
        int[] o = solve(a);
        for (int i : o)
            System.out.print(i + " ");
    }

    public static int[] solve(int a[]) {
        Stack<Integer> s = new Stack<>();

        int count = 0;

        int n = a.length;

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.isEmpty())
                output[count++] = -1;
            else if (s.peek() < a[i])
                output[count++] = s.peek();
            else {
                while (!s.isEmpty() && s.peek() >= a[i])
                    s.pop();
                if (s.isEmpty())
                    output[count++] = -1;
                else
                    output[count++] = s.peek();
            }
            s.push(a[i]);

        }
        return output;
    }
}
