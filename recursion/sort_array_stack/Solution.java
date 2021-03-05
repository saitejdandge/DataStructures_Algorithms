package recursion.sort_array_stack;

import java.util.Random;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        Stack<Integer> list = new Stack<>();

        Random rand = new Random();
        for (int i = 0; i < 100; i++)
            list.push(rand.nextInt(10));
        sort(list);
        for (int i : list)
            System.out.print(i + " ");
    }

    public static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.size() == 1)
            return stack;
        int temp = stack.pop();
        insert(sort(stack), temp);
        return stack;
    }

    private static void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insert(stack, value);
        stack.push(temp);

    }
}
