package stack;

import java.util.Stack;

public class MaxAreaHistorgram {

    public static void main(String[] args) {
        int h[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.print(solve(h));
    }

    public static int solve(int a[]) {

        int n = a.length;
        int[] left = nsl(a);
        int[] right = nsr(a);
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int area = Math.abs(Math.abs(left[i] - right[i]) - 1) * a[i];
            if (area > max)
                max = area;
        }

        return max;
    }

    public static int[] nsl(int a[]) {
        int n = a.length;
        int[] output = new int[n];
        int counter = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {

            if (s.isEmpty()) {
                output[counter++] = -1;
            } else if (a[s.peek()] < a[i]) {
                output[counter++] = s.peek();
            } else {

                while (!s.isEmpty() && a[s.peek()] >= a[i])
                    s.pop();
                if (s.isEmpty())
                    output[counter++] = -1;
                else
                    output[counter++] = s.peek();
            }
            s.push(i);
        }
        return output;
    }

    public static int[] nsr(int a[]) {
        int n = a.length;
        int[] output = new int[n];
        int counter = n - 1;
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                output[counter--] = n;
            } else if (a[s.peek()] < a[i])
                output[counter--] = s.peek();
            else {
                while (!s.isEmpty() && a[s.peek()] >= a[i])
                    s.pop();

                if (s.isEmpty()) {
                    output[counter--] = n;
                } else {
                    output[counter--] = s.peek();
                }
            }
            s.push(i);
        }
        return output;
    }
}
