package recursion.reverse_stack;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 100; i++)
            stack.push(i);

        reverse(stack);
        for (int i : stack)
            System.out.print(i + " ");
    }

    public static void reverse(Stack<Integer> s) {
        if (s.size() == 1)
            return;
        int temp = s.pop();
        reverse(s);
        insert(s, temp);
    }

    private static void insert(Stack<Integer> s, int value) {
        if (s.empty()) {
            s.push(value);
            return;
        }

        int temp = s.pop();
        insert(s, value);
        s.push(temp);
    }
}
