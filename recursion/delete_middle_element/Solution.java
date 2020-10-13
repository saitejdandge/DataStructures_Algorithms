package recursion.delete_middle_element;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        Stack<Integer> list = new Stack<>();

        for (int i = 0; i < 10; i++)
            list.push(i);
        solve(list, list.size() / 2 + 1);
        for (int i : list)
            System.out.print(i + " ");
    }

    public static void solve(Stack<Integer> stack, int k) {

        if (k == 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        solve(stack, k - 1);
        stack.push(temp);

    }
}
